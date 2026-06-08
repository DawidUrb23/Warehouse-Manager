package com.warehouse.dto;

import com.warehouse.entity.Warehouse;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter
public class WarehouseDto extends RepresentationModel<WarehouseDto> {

    private Long id;

    private String warehouseName;

    private String address;

    private Long capacity;


}
