package com.warehouse.dto;

import com.warehouse.entity.Warehouse;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter
public class WarehouseDto {

    private Long id;

    private String warehouseName;

    private String address;

    private Long capacity;


}
