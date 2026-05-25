package com.warehouse.controller;

import com.warehouse.dto.WarehouseDto;
import com.warehouse.entity.Warehouse;
import com.warehouse.repository.WarehouseRepository;
import com.warehouse.service.WarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WarehouseDto createWarehouse(@RequestBody WarehouseDto warehouseDto){
        return warehouseService.createWarehouse(warehouseDto);
    }

    @GetMapping("/{id}")
    public WarehouseDto getWarehouseById(@PathVariable Long id){
        return warehouseService.getWarehouseById(id);
    }

    @GetMapping
    public List<WarehouseDto> getAllWarehouse(){
        return warehouseService.getAllWarehouse();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWarehousById(@PathVariable Long id){
        warehouseService.deleteWarehouseById(id);
    }

    @PatchMapping("/{id}")
    public void updateWarehouse(@RequestBody WarehouseDto warehouseDto, @PathVariable Long id){
        warehouseService.updateWarehouse(warehouseDto,id);
    }
}
