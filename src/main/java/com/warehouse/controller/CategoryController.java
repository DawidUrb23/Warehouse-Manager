package com.warehouse.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.warehouse.dto.CategoryDto;
import com.warehouse.entity.Category;
import com.warehouse.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
        CategoryDto created = categoryService.createCategory(categoryDto);
        created.add(linkTo(methodOn(CategoryController.class).getCategoryById(created.getId())).withSelfRel());
        return created;
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id){
        CategoryDto categoryDto = categoryService.getCategoryById(id);

        categoryDto.add(linkTo(methodOn(CategoryController.class).getCategoryById(id)).withSelfRel());
        categoryDto.add(linkTo(methodOn(CategoryController.class).getAllCategories()).withRel("get_all_categories"));
        categoryDto.add(linkTo(methodOn(CategoryController.class).getCategoryById(id)).withRel("edit_this_category"));
        return categoryDto;
    }

    @GetMapping
    public List<CategoryDto> getAllCategories(){
        List<CategoryDto> categories = categoryService.getAllCategories();
        for(CategoryDto categoryDto: categories){
            categoryDto.add(linkTo(methodOn(CategoryController.class).getCategoryById(categoryDto.getId())).withSelfRel());
        }
        return categories;
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