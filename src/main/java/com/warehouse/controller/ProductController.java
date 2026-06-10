package com.warehouse.controller;


import com.warehouse.dto.ProductDto;
import com.warehouse.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        ProductDto created = productService.createProduct(productDto);
        created.add(linkTo(methodOn(ProductController.class).getProduct(created.getId())).withSelfRel());
        return created;
    }

    @GetMapping(value = "/{id}")
    public ProductDto getProduct(@PathVariable Long id){
        ProductDto product = productService.getProduct(id);
        product.add(linkTo(methodOn(ProductController.class).getProduct(id)).withSelfRel());
        product.add(linkTo(methodOn(ProductController.class).getAllProduct()).withRel("all_products"));
        return product;
    }

    @GetMapping
    public List<ProductDto> getAllProduct(){
        List<ProductDto> products = productService.getAllProduct();
        for(ProductDto product : products){
            product.add(linkTo(methodOn(ProductController.class).getProduct(product.getId())).withSelfRel());
        }
        return products;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id){
        productService.updateProduct(productDto, id);
    }
}