package com.warehouse.controller;

import com.warehouse.dto.CustomerDto;
import com.warehouse.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerServic){
        this.customerService = customerServic;
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }
}
