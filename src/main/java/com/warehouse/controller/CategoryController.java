package com.warehouse.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.warehouse.dto.CategoryDto;
import com.warehouse.entity.Category;
import com.warehouse.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/category")
@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @PatchMapping("/{id}")
    @JsonIgnore
    public void updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Long id){
        categoryService.updateCategory(categoryDto,id);
    }

}
