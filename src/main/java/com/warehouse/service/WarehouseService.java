package com.warehouse.service;

import com.warehouse.dto.WarehouseDto;
import com.warehouse.entity.Warehouse;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.WarehouseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {


    private final WarehouseRepository warehouseRepository;
    private final ModelMapper modelMapper;

    public WarehouseService(ModelMapper modelMapper, WarehouseRepository warehouseRepository){
        this.warehouseRepository = warehouseRepository;
        this.modelMapper = modelMapper;
    }


    public WarehouseDto createWarehouse(WarehouseDto warehouseDto) {
        Warehouse warehouseToSave = modelMapper.map(warehouseDto, Warehouse.class);
        Warehouse warehouseSaved = warehouseRepository.save(warehouseToSave);
        return modelMapper.map(warehouseSaved, WarehouseDto.class);
    }

    public WarehouseDto getWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find this id"+ id));
        return modelMapper.map(warehouse, WarehouseDto.class);
    }

    public WarehouseDto deleteWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find warehouse with this id "+id));
        return modelMapper.map(warehouse, WarehouseDto.class);
    }
}
