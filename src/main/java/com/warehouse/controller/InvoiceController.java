package com.warehouse.controller;

import com.warehouse.dto.InvoiceDto;
import com.warehouse.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<InvoiceDto> getAllInvoice(){
        return invoiceService.getAllInvoice();
    }

    @GetMapping("/date")
    public List<InvoiceDto> getInvoiceByDate(@RequestParam String date){
        return invoiceService.getInvoiceByDate(date);
    }

    @GetMapping("/datebetween")
    public List<InvoiceDto> getInvoiceDateBetween(@RequestParam String startDate, @RequestParam String endDate){
        return invoiceService.getInvoiceDateBetween();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoiceById(@PathVariable Long id){
        invoiceService.deleteInvoiceById(id);
    }

    @PatchMapping("/{id}")
    public void updateInvoice(@RequestBody InvoiceDto invoiceDto, @PathVariable Long id){
        invoiceService.updateInvoice(invoiceDto, id);
    }

}
