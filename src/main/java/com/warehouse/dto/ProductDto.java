package com.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter
public class ProductDto {

    private Long id;

    private String serialNumber;

    private String status;

    private BigDecimal price;

    @JsonIgnoreProperties("products")
    private List<InvoiceDto> invoices;
}