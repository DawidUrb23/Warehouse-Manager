package com.warehouse.repository;

import com.warehouse.dto.InvoiceDto;
import com.warehouse.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
    List<InvoiceDto>
}
