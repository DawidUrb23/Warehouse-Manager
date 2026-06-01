package com.warehouse.controller;

import com.warehouse.dto.CustomerDto;
import com.warehouse.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerDto> getAllCutomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/search")
    public List<CustomerDto> getCustomerBySurname(@RequestParam(name = "name") String surname){
        return customerService.getCustomerBySurname(surname);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }

    @PatchMapping("/{id}")
    public void updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable Long id){
        customerService.updateCustomer(customerDto,id);
    }
}
