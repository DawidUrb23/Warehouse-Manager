package com.warehouse.controller;


import com.warehouse.dto.ProductDto;
import com.warehouse.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

//    public ProductController(ProductService productService){
//        this.productService = productService;
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @GetMapping(value = "/{id}")
    public ProductDto getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @GetMapping
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @PatchMapping("/{id}")
    public void updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id){
        productService.updateProduct(productDto, id);
    }
}

