package io.home.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses = SpringBootMybatisStarterApplication.class)
@SpringBootApplication
public class SpringBootMybatisStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisStarterApplication.class, args);
    }

}
