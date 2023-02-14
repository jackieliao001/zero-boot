package com.fast.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fast")
public class ZeroBootApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeroBootApiApplication.class, args);
    }

}
