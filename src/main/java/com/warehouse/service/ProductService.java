package com.warehouse.service;

import com.warehouse.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ModelMapper modelMapper, ProductRepository productRepository){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
}
