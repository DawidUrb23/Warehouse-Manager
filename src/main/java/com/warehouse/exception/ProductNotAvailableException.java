package com.warehouse.exception;

public class ProductNotAvailableException extends RuntimeException{
    public ProductNotAvailableException(String errorMessage){
        super(errorMessage);
    }
}
