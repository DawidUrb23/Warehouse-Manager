package com.warehouse.service;

import com.warehouse.dto.WarehouseDto;
import com.warehouse.entity.Category;
import com.warehouse.entity.Warehouse;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.WarehouseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final ProductRepository productRepository; // Dodane repozytorium
    private final ModelMapper modelMapper;

    public WarehouseService(ModelMapper modelMapper, WarehouseRepository warehouseRepository, ProductRepository productRepository) {
        this.warehouseRepository = warehouseRepository;
        this.modelMapper = modelMapper;
        this.productRepository = productRepository; // Dodane repozytorium
    }

    public WarehouseDto createWarehouse(WarehouseDto warehouseDto) {
        Warehouse warehouseToSave = modelMapper.map(warehouseDto, Warehouse.class);
        Warehouse warehouseSaved = warehouseRepository.save(warehouseToSave);
        return modelMapper.map(warehouseSaved, WarehouseDto.class);
    }

    public WarehouseDto getWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find this id" + id));
        return modelMapper.map(warehouse, WarehouseDto.class);
    }

    public WarehouseDto deleteWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find warehouse with this id " + id));
        return modelMapper.map(warehouse, WarehouseDto.class);
    }

    public void updateWarehouse(WarehouseDto warehouseDto, Long id) {
        Warehouse warehouseToUpdate = warehouseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot found a warehouse with this id: " + id));
        if (warehouseDto.getWarehouseName() != null) {
            warehouseToUpdate.setWarehouseName(warehouseDto.getWarehouseName());
        }
        if (warehouseDto.getCapacity() != null) {
            warehouseToUpdate.setCapacity(warehouseDto.getCapacity());
        }
        if (warehouseDto.getAddress() != null) {
            warehouseToUpdate.setAddress(warehouseToUpdate.getAddress());
        }
        warehouseRepository.save(warehouseToUpdate);
        modelMapper.map(warehouseToUpdate, warehouseDto.getClass());
    }

    public List<WarehouseDto> getAllWarehouse() {
        return warehouseRepository.findAll().stream()
                .map(warehouse -> modelMapper.map(warehouse, WarehouseDto.class))
                .collect(Collectors.toList());
    }

    public long getProductCountForCategory(Long categoryId) {
        return productRepository.countByCategoryId(categoryId);
    }


    public Map<String, Long> getWarehouseStockReport(long warehouseId) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find warehouse with this id " + warehouseId));

        return warehouse.getCategories().stream()
                .collect(Collectors.toMap(Category::getTypeName, category -> productRepository.countByCategoryId(category.getId())));

    }

}
