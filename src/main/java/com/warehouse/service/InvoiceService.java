package com.warehouse.service;

import com.warehouse.dto.InvoiceDto;
import com.warehouse.entity.Invoice;
import com.warehouse.repository.InvoiceRepository;
import com.warehouse.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public InvoiceDto deleteInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find a Invoice with this id " + id));
        return modelMapper.map(invoice, InvoiceDto.class);
    }

    public void updateInvoice(InvoiceDto invoiceDto, Long id) {
        Invoice invoiceToUpdate = invoiceRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Cannot found invoice with this id: " + id));
        if(invoiceDto.getInvoiceNumber()!=null){
            invoiceToUpdate.setInvoiceNumber(invoiceDto.getInvoiceNumber());
        }
        if(invoiceDto.getDateOfIssue()!=null){
            invoiceToUpdate.setInvoiceNumber(String.valueOf(invoiceDto.getDateOfIssue()));
        }
        if(invoiceDto.getTotalSum()!=null){
            invoiceToUpdate.setTotalSum(invoiceDto.getTotalSum());
        }
        invoiceRepository.save(invoiceToUpdate);
        modelMapper.map(invoiceToUpdate, InvoiceDto.class);
    }

    public List<InvoiceDto> getAllInvoice() {
        return invoiceRepository.findAll().stream()
                .map(invoice -> modelMapper.map(invoice,InvoiceDto.class))
                .collect(Collectors.toList());
    }
}
