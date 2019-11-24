package com.product.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa główna wywołująca usługe REST odpowiadającą za produkty na porcie 8082
 */
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication product = new SpringApplication(ProductApplication.class);
        product.setDefaultProperties(Collections
                .singletonMap("server.port", "8082"));
        product.run(args);
    }
}
