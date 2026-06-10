package com.warehouse.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;

    private String serialNumber;

    private String status;

    private BigDecimal price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "catId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invId")
    private Invoice invoice;
}