package com.warehouse.service;

import com.warehouse.dto.CategoryDto;
import com.warehouse.entity.Category;
import com.warehouse.repository.CategoryRepository;
import com.warehouse.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(ModelMapper modelMapper, CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public CategoryDto createCategory(CategoryDto categoryDto)
    {
        Category categoryToSave = modelMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepository.save(categoryToSave);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }


    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find this id" + id));
        return modelMapper.map(category, CategoryDto.class);
    }

    public CategoryDto deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find this id" + id));
        categoryRepository.delete(category);
        return modelMapper.map(category, CategoryDto.class);
    }

    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {
        Category categoryToUpdate = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find category with this id" + id));
        if(categoryDto.getDescription()!=null){
            categoryToUpdate.setDescription(categoryDto.getDescription());
        }
        if(categoryDto.getTypeName()!=null){
            categoryToUpdate.setTypeName(categoryDto.getTypeName());
        }
        if(categoryDto.getProducts()!=null){
            categoryToUpdate.setProducts(categoryDto.getProducts());
        }
        if(categoryDto.getWarehouse()!=null){
            categoryToUpdate.setWarehouse(categoryDto.getWarehouse());
        }
        categoryRepository.save(categoryToUpdate);
        return modelMapper.map(categoryToUpdate, CategoryDto.class);
    }
}
