package io.home.test.app.product.service;

import io.home.test.app.product.domain.Product;
import io.home.test.app.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Product> findAll() {
        return productMapper.findAll();
    }

    public Product findById(Long id) {
        return productMapper.findById(id);
    }

    public void save(Product product) {
        productMapper.save(product);
    }

    public void update(Product product) {
        productMapper.update(product);
    }

    public void deleteById(Long id) {
        productMapper.deleteById(id);
    }

    public String now() throws Exception {
        return productMapper.now();
    }

}
