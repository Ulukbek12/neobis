package com.example.week4.exception;

public class ProductNotFoundException extends RuntimeException{
   public ProductNotFoundException(Long id){
        super("Could not find a product with " + id);
    }
}
