package com.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter
public class InvoiceDto extends RepresentationModel<InvoiceDto> {

    private Long id;

    private String invoiceNumber;

    private LocalDate dateOfIssue;

    private BigDecimal totalSum;

    @JsonIgnoreProperties("invoices")
    private List<ProductDto> products;
}