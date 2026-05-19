package com.warehouse.controller;

import com.warehouse.dto.InvoiceDto;
import com.warehouse.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
