package com.credit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class CreditApplication {
    public static void main(String[] args) {
        SpringApplication credit = new SpringApplication(CreditApplication.class);
        credit.setDefaultProperties(Collections
                .singletonMap("server.port", "8080"));
        credit.run(args);
    }
}
