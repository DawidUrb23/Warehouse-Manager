package com.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductDto {

    private Long id;

    private String serialNumber;

    private String status;

    private BigDecimal price;

    @JsonIgnoreProperties("products")
    private List<InvoiceDto> invoices;
}