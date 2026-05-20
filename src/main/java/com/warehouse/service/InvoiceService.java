package com.warehouse.service;

import com.warehouse.dto.InvoiceDto;
import com.warehouse.entity.Invoice;
import com.warehouse.repository.InvoiceRepository;
import com.warehouse.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        Invoice invoiceToSave = modelMapper.map(invoiceDto, Invoice.class);
        Invoice invoiceSaved = invoiceRepository.save(invoiceToSave);
        return modelMapper.map(invoiceSaved, InvoiceDto.class);
    }

    public InvoiceDto getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find this id" + id));
        return modelMapper.map(invoice,InvoiceDto.class);
    }
}
