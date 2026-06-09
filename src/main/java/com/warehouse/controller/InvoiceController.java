package com.warehouse.controller;

import com.warehouse.dto.InvoiceDto;
import com.warehouse.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceDto createInvoice(@RequestBody InvoiceDto invoiceDto){
        InvoiceDto invoice = invoiceService.createInvoice(invoiceDto);
        invoice.add(linkTo(methodOn(InvoiceController.class).getInvoiceById(invoice.getId())).withSelfRel());
        return invoice;
    }

    @GetMapping("/{id}")
    public InvoiceDto getInvoiceById(@PathVariable Long id){
        InvoiceDto invoice = invoiceService.getInvoiceById(id);

        invoice.add(linkTo(methodOn(InvoiceController.class).getInvoiceById(id)).withSelfRel());
        invoice.add(linkTo(methodOn(InvoiceController.class).getAllInvoice()).withRel("get_all_invoices"));
        invoice.add(linkTo(methodOn(InvoiceController.class).getInvoiceById(id)).withRel("edit_this_invoice"));

        return invoice;
    }

    @GetMapping
    public List<InvoiceDto> getAllInvoice(){
        List<InvoiceDto> invoices = invoiceService.getAllInvoice();
        for(InvoiceDto invoice : invoices){
            invoice.add(linkTo(methodOn(InvoiceController.class).getInvoiceById(invoice.getId())).withSelfRel());
        }
        return invoices;
    }

    @GetMapping("/date")
    public List<InvoiceDto> getInvoiceByDate(@RequestParam String date){
        List<InvoiceDto> invoices = invoiceService.getInvoiceByDate(date);
        for(InvoiceDto invoice : invoices){
            invoice.add(linkTo(methodOn(InvoiceController.class).getInvoiceById(invoice.getId())).withSelfRel());
        }
        return invoices;
    }

    @GetMapping("/datebetween")
    public List<InvoiceDto> getInvoiceDateBetween(@RequestParam String startDate, @RequestParam String endDate){
        List<InvoiceDto> invoices = invoiceService.getInvoiceDateBetween(startDate, endDate);
        for(InvoiceDto invoice : invoices){
            invoice.add(linkTo(methodOn(InvoiceController.class).getInvoiceById(invoice.getId())).withSelfRel());
        }
        return invoices;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoiceById(@PathVariable Long id){
        invoiceService.deleteInvoiceById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@RequestBody InvoiceDto invoiceDto, @PathVariable Long id){
        invoiceService.updateInvoice(invoiceDto, id);
    }

}