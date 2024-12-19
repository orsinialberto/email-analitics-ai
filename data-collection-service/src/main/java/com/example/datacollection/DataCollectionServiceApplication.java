package com.example.datacollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.common.entity")
@EnableJpaRepositories
public class DataCollectionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataCollectionServiceApplication.class, args);
    }
}