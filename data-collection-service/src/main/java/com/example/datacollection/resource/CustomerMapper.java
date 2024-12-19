package com.example.datacollection.resource;

import com.example.common.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerRes resource);

    @Mapping(target = "customerId", source = "customerId")
    CustomerRes toResource(Customer entity);
}