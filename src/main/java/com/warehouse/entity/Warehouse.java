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
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "war_id")
    private Long id;

    private String warehouseName;

    private String address;

    private Long capacity;

    @OneToMany(mappedBy = "warehouse")
    private List<Category> categories;


}
