package com.warehouse.exception;

public class CategoryNotEmptyException extends RuntimeException{
    public  CategoryNotEmptyException(String errorMessage){
        super(errorMessage);
    }
}
