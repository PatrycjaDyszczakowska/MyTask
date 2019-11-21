package com.product.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication product = new SpringApplication(ProductApplication.class);
        product.setDefaultProperties(Collections
                .singletonMap("server.port", "8082"));
        product.run(args);
    }
}
