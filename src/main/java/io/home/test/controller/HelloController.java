package io.home.test.controller;

import io.home.test.app.product.domain.Product;
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
        //model.addAttribute("result" , productService.findAll());

        // jsp 페이지 호출
        return "hello";
    }

    @RequestMapping(value = "/hello2" , method= RequestMethod.GET)
    public String Hello2() {
        // Spring 에서 제공하는 Model 객체를 사용하여 뷰페이지에 데이터를 넘겨준다.
        //model.addAttribute("result" , productService.findAll());

        // jsp 페이지 호출
        return "hello2";
    }


    /**
     * 글쓰기 화면
     * @return
     */
    @RequestMapping("/insertBoardView")
    public String insertBoardView() {
        return "insertBoard";
    }

    /**
     * 글쓰기 처리
     * @param
     * @return
     */
    @RequestMapping("/insertBoard")
    public String insertBoard(Product product) {
        productService.save(product);
        return "redirect:hello";
    }

    /**
     * 상세 글 보기
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/getBoard")
    public String getBoard(Product product, Model model) {
        model.addAttribute("board", productService.findById(product.getId()) );
        return "getBoard";
    }

    /**
     * 글 수정 처리 후 목록으로 이동
     * @param
     * @return
     */
    @RequestMapping("/updateBoard")
    public String updateBoard(Product product) {
        productService.update(product);
        return "redirect:hello";
    }

    /**
     * 글 삭제 처리 후 목록으로 이동
     * @param
     * @return
     */
    @RequestMapping("/deleteBoard")
    public String deleteBoard(Product product) {
        productService.deleteById(product.getId());
        return "redirect:hello";
    }

}