package com.warehouse.service;

import com.warehouse.dto.CustomerDto;
import com.warehouse.entity.Customer;
import com.warehouse.repository.CustomerRepository;
import com.warehouse.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void deleteCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find customer with this id " + id));
        customerRepository.delete(customer);
    }

    public void updateCustomer(CustomerDto customerDto, Long id) {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find customer"+id));
        if(customerDto.getName()!= null){
            customerToUpdate.setName(customerDto.getName());
        }
        if(customerDto.getEmail()!=null){
            customerToUpdate.setEmail(customerDto.getEmail());
        }
        if(customerDto.getAddress() != null){
            customerToUpdate.setAddress(customerDto.getAddress());
        }
        if(customerDto.getSurname()!=null){
            customerToUpdate.setSurname(customerDto.getSurname());
        }
        if(customerDto.getPhoneNumber()!=null){
            customerToUpdate.setPhoneNumber(customerDto.getPhoneNumber());
        }
        customerRepository.save(customerToUpdate);
        modelMapper.map(customerToUpdate, CustomerDto.class);
    }

    public List<CustomerDto> getAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> modelMapper.map(customer,CustomerDto.class))
                .collect(Collectors.toList());
    }

    public List<CustomerDto> getCustomerBySurname(String surname) {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for(Customer customer: customers){
            if(customer.getSurname().equals(surname)){
                customerDtos.add(CustomerDto.builder()
                                .surname(customer.getSurname())
                                .email(customer.getEmail())
                                .name(customer.getName())
                                .address(customer.getAddress())
                                .phoneNumber(customer.getPhoneNumber())
                                .id(customer.getId())
                        .build());
            }
        }
        if(customerDtos.isEmpty()){
            throw new EntityNotFoundException("Cannot found an customer with this surname: "+ surname);
        }
        return customerDtos;
    }
}
