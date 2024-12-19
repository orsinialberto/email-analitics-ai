package com.example.datacollection.resource;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerRes {
    private String customerId;
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
    private String properties;
}
