package com.warehouse.service;

import com.warehouse.dto.ProductDto;
import com.warehouse.dto.WarehouseDto;
import com.warehouse.entity.Category;
import com.warehouse.entity.Product;
import com.warehouse.entity.Warehouse;
import com.warehouse.repository.CategoryRepository;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.WarehouseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public ProductService(ModelMapper modelMapper, ProductRepository productRepository, WarehouseRepository warehouseRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.warehouseRepository = warehouseRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDto createProduct(ProductDto productDto) {
        if(productDto.getCategoryId() == null){
            throw new IllegalArgumentException("You must add category id for new Product");
        }
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found."));
        Warehouse warehouse = category.getWarehouse();
        if(warehouse == null){
            throw new IllegalStateException("Category is not assigned to any warehouse");
        }
        long currentProductsCount = productRepository.countByCategory_Warehouse_Id(warehouse.getId());
        if(currentProductsCount >= warehouse.getCapacity()){
            throw new RuntimeException("Warehouse " + warehouse.getWarehouseName() + " is acctualy full max capacity is "+ warehouse.getCapacity());
        }
        Product productToSave = modelMapper.map(productDto, Product.class);
        WarehouseDto warehouseDto = new WarehouseDto();
        productToSave.setCategory(category);
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