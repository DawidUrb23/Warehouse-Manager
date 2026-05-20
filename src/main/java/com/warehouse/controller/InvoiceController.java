package com.warehouse.controller;

import com.warehouse.dto.InvoiceDto;
import com.warehouse.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {

    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceDto createInvoice(@RequestBody InvoiceDto invoiceDto){
        return invoiceService.createInvoice(invoiceDto);
    }

    @GetMapping("invoice/{id}")
    public InvoiceDto getInvoiceById(@RequestParam Long id){
        return invoiceService.getInvoiceById(id);
    }
}
