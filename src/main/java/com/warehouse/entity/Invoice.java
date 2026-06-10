package com.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invId")
    private Long id;

    private String invoiceNumber;

    private LocalDate dateOfIssue;

    private BigDecimal totalSum;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<Product> products;

    @JoinColumn(name = "customer_id", referencedColumnName = "cusId")
    @ManyToOne
    private  Customer customer;
}