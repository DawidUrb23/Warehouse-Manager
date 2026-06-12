package com.warehouse.repository;

import com.warehouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    long countById(long id);
    long countByCategory_Warehouse_Id(Long warehouseId);
}