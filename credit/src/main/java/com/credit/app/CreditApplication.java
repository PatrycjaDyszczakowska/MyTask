package com.credit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;


@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CreditApplication {
    public static void main(String[] args) {
        SpringApplication credit = new SpringApplication(CreditApplication.class);
        credit.setDefaultProperties(Collections
                .singletonMap("server.port", "8080"));
        credit.run();
    }
}
