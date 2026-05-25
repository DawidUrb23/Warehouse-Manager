package com.warehouse.service;

import com.warehouse.dto.ProductDto;
import com.warehouse.entity.Product;
import com.warehouse.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public ProductDto deleteProductById(Long id) {
        Product productToDelete = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find a product"+id));
        return modelMapper.map(productToDelete, ProductDto.class);
    }

    public void updateProduct(ProductDto productDto, Long id) {
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot found a product: " + id));
        if(productDto.getStatus()!=null){
            productToUpdate.setStatus(productDto.getStatus());
        }
        if(productDto.getSerialNumber()!=null){
            productToUpdate.setSerialNumber(productDto.getSerialNumber());
        }
        productRepository.save(productToUpdate);
        modelMapper.map(productToUpdate,ProductDto.class);
    }

    public List<ProductDto> getAllProduct() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product,ProductDto.class))
                .collect(Collectors.toList());
    }
}
