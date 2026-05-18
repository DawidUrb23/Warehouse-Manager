package com.warehouse.service;

import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.WarehouseRepository;
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


}
