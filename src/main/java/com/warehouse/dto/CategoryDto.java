package com.warehouse.dto;

import com.warehouse.entity.Product;
import com.warehouse.entity.Warehouse;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Long id;

    private String typeName;

    private String description;

    private Warehouse warehouse;

    private List<Product> products;
}
