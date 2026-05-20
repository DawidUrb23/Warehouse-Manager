package com.warehouse.service;

import com.warehouse.dto.ProductDto;
import com.warehouse.entity.Product;
import com.warehouse.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public ProductDto createProduct(ProductDto productDto) {
        Product productToSave = modelMapper.map(productDto, Product.class);
        Product productSaved = productRepository.save(productToSave);
        return modelMapper.map(productSaved, ProductDto.class);
    }

    public ProductDto getProduct(Long id) {
        Product productToGet = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find this ID" + id));
        return modelMapper.map(productToGet, ProductDto.class);
    }
}
