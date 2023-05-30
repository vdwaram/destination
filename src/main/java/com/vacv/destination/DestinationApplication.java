package com.vacv.destination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
@SpringBootApplication
@EnableConfigurationProperties
public class DestinationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DestinationApplication.class, args);
    }

}
