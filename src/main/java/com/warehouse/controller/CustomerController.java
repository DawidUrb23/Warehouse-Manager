package com.warehouse.controller;

import com.warehouse.dto.CustomerDto;
import com.warehouse.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto created = customerService.createCustomer(customerDto);
        created.add(linkTo(methodOn(CustomerController.class).getCustomerById(created.getId())).withSelfRel());
        return created;
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id){
        CustomerDto customer = customerService.getCustomerById(id);

        customer.add(linkTo(methodOn(CustomerController.class).getCustomerById(id)).withSelfRel());
        customer.add(linkTo(methodOn(CustomerController.class).getAllCustomer()).withRel("all_customers"));
        customer.add(linkTo(methodOn(CustomerController.class).getCustomerById(id)).withRel("edit_this_client"));
        return customer;
    }

    @GetMapping
    public List<CustomerDto> getAllCustomer(){
        List<CustomerDto> customers = customerService.getAllCustomer();
        for(CustomerDto customer: customers){
            customer.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel());
        }
        return customers;
    }

    @GetMapping("/search")
    public List<CustomerDto> getCustomerBySurname(@RequestParam(name = "name") String surname){
        List<CustomerDto> customerDtoList = customerService.getCustomerBySurname(surname);
        
        for(CustomerDto customerDto: customerDtoList){
            customerDto.add(linkTo(methodOn(CustomerController.class).getCustomerById(customerDto.getId())).withSelfRel());
        }
        return customerDtoList;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable Long id){
        customerService.updateCustomer(customerDto,id);
    }
}