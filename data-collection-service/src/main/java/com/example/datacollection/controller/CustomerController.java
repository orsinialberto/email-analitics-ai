package com.example.datacollection.controller;

import com.example.datacollection.resource.CustomerRes;
import com.example.datacollection.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customers")
    @ResponseStatus(CREATED)
    public CustomerRes createCustomer(@RequestBody final CustomerRes customerRes) {
        return customerService.createCustomer(customerRes);
    }

    @GetMapping("/customers")
    @ResponseStatus(OK)
    public List<CustomerRes> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    @ResponseStatus(OK)
    public CustomerRes getCustomer(@PathVariable final String customerId) {
        return customerService.getCustomerById(customerId);
    }

    @DeleteMapping("/customers")
    @ResponseStatus(NO_CONTENT)
    public void deleteCustomers() {
        customerService.deleteAll();
    }

    @DeleteMapping("/customers/{customerId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteCustomers(@PathVariable final String customerId) {
        customerService.delete(customerId);
    }
}
