package com.warehouse.service;

import com.warehouse.dto.CustomerDto;
import com.warehouse.entity.Customer;
import com.warehouse.repository.CustomerRepository;
import com.warehouse.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customerToSave = modelMapper.map(customerDto, Customer.class);
        Customer customerSaved = customerRepository.save(customerToSave);
        return modelMapper.map(customerSaved, CustomerDto.class);
    }

    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot fin this id" + id));
        return modelMapper.map(customer, CustomerDto.class);

    }

    public CustomerDto deleteCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find customer with this id " + id));
        return modelMapper.map(customer, CustomerDto.class);
    }
}
