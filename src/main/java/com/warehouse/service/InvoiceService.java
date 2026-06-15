package com.warehouse.service;

import com.warehouse.dto.InvoiceDto;
import com.warehouse.dto.ProductDto;
import com.warehouse.entity.Invoice;
import com.warehouse.entity.Product;
import com.warehouse.exception.ProductNotAvailableException;
import com.warehouse.repository.InvoiceRepository;
import com.warehouse.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class InvoiceService {


    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public InvoiceService(ModelMapper modelMapper, InvoiceRepository invoiceRepository, ProductRepository productRepository) {
        this.invoiceRepository = invoiceRepository;
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        Invoice invoiceToSave = modelMapper.map(invoiceDto, Invoice.class);
        BigDecimal sum = BigDecimal.ZERO;
        List<Product> productToList = new ArrayList<>();

        if (invoiceDto.getProducts() != null) {
            for (ProductDto productDto : invoiceDto.getProducts()) {
                Product product = productRepository.findById(productDto.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Cannot found product with this ID" + productDto.getId()));
                if (product.getPrice() != null) {
                    sum = sum.add(product.getPrice());
                }
                productToList.add(product);
            }
        }

        invoiceToSave.setTotalSum(sum);
        invoiceToSave.setProducts(productToList);
        Invoice invoiceSaved = invoiceRepository.save(invoiceToSave);
        return modelMapper.map(invoiceSaved, InvoiceDto.class);
    }

    public InvoiceDto getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find this id" + id));
        return modelMapper.map(invoice, InvoiceDto.class);
    }

    public InvoiceDto deleteInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find a Invoice with this id " + id));
        invoiceRepository.delete(invoice);
        return modelMapper.map(invoice, InvoiceDto.class);
    }

    public void updateInvoice(InvoiceDto invoiceDto, Long id) {
        Invoice invoiceToUpdate = invoiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot found invoice with this id: " + id));
        if (invoiceDto.getInvoiceNumber() != null) {
            invoiceToUpdate.setInvoiceNumber(invoiceDto.getInvoiceNumber());
        }
        if (invoiceDto.getDateOfIssue() != null) {
            invoiceToUpdate.setDateOfIssue(invoiceDto.getDateOfIssue());
        }
        if (invoiceDto.getTotalSum() != null) {
            invoiceToUpdate.setTotalSum(invoiceDto.getTotalSum());
        }
        invoiceRepository.save(invoiceToUpdate);
        modelMapper.map(invoiceToUpdate, InvoiceDto.class);
    }

    public List<InvoiceDto> getAllInvoice() {
        return invoiceRepository.findAll().stream()
                .map(invoice -> modelMapper.map(invoice, InvoiceDto.class))
                .collect(Collectors.toList());
    }

    public List<InvoiceDto> getInvoiceByDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        List<Invoice> invoices = invoiceRepository.findAll();
        List<InvoiceDto> invoiceDtos = new ArrayList<>();
        for (Invoice invoice : invoices) {
            if (invoice.getDateOfIssue().equals(date)) {
                invoiceDtos.add(InvoiceDto.builder()
                        .id(invoice.getId())
                        .invoiceNumber(invoice.getInvoiceNumber())
                        .dateOfIssue(invoice.getDateOfIssue())
                        .totalSum(invoice.getTotalSum())
                        .build());
            }
        }
        if (invoiceDtos.isEmpty()) {
            throw new EntityNotFoundException("Cannot found invoice with this date.");
        }
        return invoiceDtos;
    }

    public List<InvoiceDto> getInvoiceDateBetween(String startDateString, String endDateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(startDateString, formatter);
        LocalDate endDate = LocalDate.parse(endDateString, formatter);
        List<Invoice> invoices = invoiceRepository.findByDateOfIssueBetween(startDate, endDate);

        return invoices.stream()
                .map(invoice -> modelMapper.map(invoice, InvoiceDto.class))
                .collect(Collectors.toList());
    }

    public void assignProductsToInvoice(Long id, List<Long> productsIds) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find invoice with this id: " + id));
        List<Product>products = productRepository.findAllById(productsIds);
        for(Product product : products){
            if(!product.getStatus().equalsIgnoreCase("AVAILABLE")){
                throw new ProductNotAvailableException("Product with this id "+ product.getId()+ " is not available");
            }
            product.setInvoice(invoice);
            product.setStatus("SOLD");
        }
        productRepository.saveAll(products);
    }
}