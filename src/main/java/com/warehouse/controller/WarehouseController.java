package com.warehouse.controller;

import com.warehouse.dto.WarehouseDto;
import com.warehouse.service.WarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WarehouseDto createWarehouse(@RequestBody WarehouseDto warehouseDto){
        WarehouseDto created = warehouseService.createWarehouse(warehouseDto);
        created.add(linkTo(methodOn(WarehouseController.class).getWarehouseById(created.getId())).withSelfRel());
        return created;
    }

    @GetMapping("/{id}")
    public WarehouseDto getWarehouseById(@PathVariable Long id){
        WarehouseDto warehouse = warehouseService.getWarehouseById(id);
        
        warehouse.add(linkTo(methodOn(WarehouseController.class).getWarehouseById(id)).withSelfRel());
        warehouse.add(linkTo(methodOn(WarehouseController.class).getAllWarehouse()).withRel("all_warehouses"));
        
        return warehouse;
    }

    @GetMapping
    public List<WarehouseDto> getAllWarehouse(){
        List<WarehouseDto> warehouses = warehouseService.getAllWarehouse();
        for(WarehouseDto warehouse : warehouses){
            warehouse.add(linkTo(methodOn(WarehouseController.class).getWarehouseById(warehouse.getId())).withSelfRel());
        }
        return warehouses;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWarehousById(@PathVariable Long id){
        warehouseService.deleteWarehouseById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateWarehouse(@RequestBody WarehouseDto warehouseDto, @PathVariable Long id){
        warehouseService.updateWarehouse(warehouseDto,id);
    }
}