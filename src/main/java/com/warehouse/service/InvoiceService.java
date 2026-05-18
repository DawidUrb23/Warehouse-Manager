package com.warehouse.service;

import com.warehouse.repository.InvoiceRepository;
import com.warehouse.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {


    private final InvoiceRepository invoiceRepository;
    private final ModelMapper modelMapper;

    public InvoiceService(ModelMapper modelMapper, InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
        this.modelMapper = modelMapper;
    }
}
