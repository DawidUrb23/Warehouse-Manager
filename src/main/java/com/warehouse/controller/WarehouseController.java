package com.warehouse.controller;

import com.warehouse.repository.WarehouseRepository;
import com.warehouse.service.WarehouseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

    private WarehouseRepository warehouseRepository;

    public WarehouseController(WarehouseRepository warehouseRepository){
        this.warehouseRepository = warehouseRepository;
    }

//    @PostMapping
//    public
}
