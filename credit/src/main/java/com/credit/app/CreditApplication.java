package com.credit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author Patrycja Dyszczakowska
 * @version 1.0
 * Klasa główna wywołująca usługe REST odpowiadającą za kredyty na porcie 8080
 */
@SpringBootApplication
public class CreditApplication {
    public static void main(String[] args) {
        SpringApplication credit = new SpringApplication(CreditApplication.class);
        credit.setDefaultProperties(Collections
                .singletonMap("server.port", "8080"));
        credit.run(args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
