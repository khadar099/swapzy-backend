package com.swapzy;  // Ensure that this matches your package structure

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // This annotation marks the class as the main entry point for the application
public class SwapzyAppApplication {

    public static void main(String[] args) {
        // Launch the Spring Boot application
        SpringApplication.run(SwapzyAppApplication.class, args);
    }
}

