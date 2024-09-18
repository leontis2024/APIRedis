package com.example.leontisredis;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class LeontisRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeontisRedisApplication.class, args);
    }

}
