package com.warehouse.dto;

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

    public List<Long> productId;
}
