package com.warehouse.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warId")
    private Long id;

    private String warehouseName;

    private String address;

    private Long capacity;

    @OneToMany(mappedBy = "warehouse", fetch = FetchType.LAZY)
    private List<Category> categories;


}
