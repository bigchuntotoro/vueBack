package io.home.test.controller;

import io.home.test.app.product.service.ProductService;
import io.home.test.app.product.web.ProductResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.home.test.app.product.service.ProductService;

@Controller
public class HelloController {

    Logger LOG = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/hello" , method= RequestMethod.GET)
    public String Hello(Model model) {
        // Spring 에서 제공하는 Model 객체를 사용하여 뷰페이지에 데이터를 넘겨준다.
        model.addAttribute("name" , "테스터");
        model.addAttribute("result" , productService.findAll());

        // jsp 페이지 호출
        return "hello";
    }

}