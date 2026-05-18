package com.warehouse.service;

import com.warehouse.repository.CustomerRepository;
import com.warehouse.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerService(ModelMapper modelMapper, CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }
}
