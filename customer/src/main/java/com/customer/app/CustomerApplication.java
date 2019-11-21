package com.customer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication customer = new SpringApplication(CustomerApplication.class);
        customer.setDefaultProperties(Collections
                .singletonMap("server.port", "8081"));
        customer.run(args);
    }
}
