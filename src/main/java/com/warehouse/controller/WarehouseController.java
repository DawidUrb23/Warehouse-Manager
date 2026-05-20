package com.warehouse.controller;

import com.warehouse.dto.WarehouseDto;
import com.warehouse.entity.Warehouse;
import com.warehouse.repository.WarehouseRepository;
import com.warehouse.service.WarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class WarehouseController {

    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }

    @PostMapping("/warehouse")
    @ResponseStatus(HttpStatus.CREATED)
    public WarehouseDto createWarehouse(@RequestBody WarehouseDto warehouseDto){
        return warehouseService.createWarehouse(warehouseDto);
    }

    @GetMapping("/warehouse/{id}")
    public WarehouseDto getWarehouseById(@RequestParam Long id){
        return warehouseService.getWarehouseById(id);
    }
}
