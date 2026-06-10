package com.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter
public class ProductDto extends RepresentationModel<ProductDto> {

    private Long id;

    private String serialNumber;

    private String status;

    private BigDecimal price;

    @JsonIgnoreProperties("products")
    private InvoiceDto invoice;
}