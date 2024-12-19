package com.example.datacollection.resource;

import com.example.common.entity.Customer;
import com.example.common.entity.EventType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventRes {
    private String eventId;
    private Customer customer;
    private EventType type;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
    private String properties;
}
