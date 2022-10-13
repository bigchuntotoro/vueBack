package io.home.test.app.product.web;

import io.home.test.app.product.domain.Product;
import io.home.test.app.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@RequestMapping(value = "/api/products")
@RestController
public class ProductResource {

    Logger LOG = LoggerFactory.getLogger(ProductResource.class);

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productService.findAll();
         return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable(value = "id") Long id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping(value = "/test/save")
    public ResponseEntity<?> testSave() {
        Product product = new Product();
        product.setName("test-product");
        product.setPrice(BigDecimal.valueOf(15000L));
        productService.save(product);
        return ResponseEntity.ok("saved");
    }

    @GetMapping(value = "/test/delete")
    public ResponseEntity<?> testDelete(@RequestParam(value = "id") long id) {
        productService.deleteById(id);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping(value = "/test/update")
    public ResponseEntity<?> testUpdate(@RequestParam(value = "id") long id) {
        Product oldProduct = productService.findById(id);

        oldProduct.setName("new Name");
        oldProduct.setDescription("new Description");
        oldProduct.setUpdatedDate(ZonedDateTime.now());

        productService.update(oldProduct);
        return ResponseEntity.ok("updated");
    }

    @GetMapping(value = "/now")
    public ResponseEntity<?> now() throws Exception {
        String now = productService.now();
        return ResponseEntity.ok(now);
    }
}
