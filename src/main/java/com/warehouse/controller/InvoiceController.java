package com.warehouse.controller;

import com.warehouse.dto.InvoiceDto;
import com.warehouse.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceDto createInvoice(@RequestBody InvoiceDto invoiceDto){
        return invoiceService.createInvoice(invoiceDto);
    }

    @GetMapping("/{id}")
    public InvoiceDto getInvoiceById(@PathVariable Long id){
        return invoiceService.getInvoiceById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoiceById(@PathVariable Long id){
        invoiceService.deleteInvoiceById(id);
    }
}
