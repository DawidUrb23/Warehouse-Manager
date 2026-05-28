package com.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class InvoiceDto {

    private Long id;

    private String invoiceNumber;

    private LocalDate dateOfIssue;

    private BigDecimal totalSum;

    @JsonIgnoreProperties("invoices")
    private List<ProductDto> products;
}