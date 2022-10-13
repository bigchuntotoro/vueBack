package io.home.test.app.product.mapper;

import io.home.test.app.product.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void update(Product product);

    void deleteById(Long id);

    //    @Select("SELECT CURRENT_TIMESTAMP result FROM sysibm.sysdummy1")    // db2
    @Select("SELECT CURRENT_TIMESTAMP FROM DUAL")    // H2
    String now() throws Exception;

}
