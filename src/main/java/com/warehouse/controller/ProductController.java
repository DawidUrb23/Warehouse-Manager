package com.warehouse.controller;


import com.warehouse.dto.ProductDto;
import com.warehouse.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

//    public ProductController(ProductService productService){
//        this.productService = productService;
//    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @GetMapping(value = "product/{id}")
    public ProductDto getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

}
