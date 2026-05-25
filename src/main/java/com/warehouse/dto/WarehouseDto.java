package com.warehouse.dto;

import com.warehouse.entity.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WarehouseDto {

    private Long id;

    private String warehouseName;

    private String address;

    private Long capacity;


}
