package com.example.week5.exception;

public class ProductNotFoundException extends RuntimeException{
   public ProductNotFoundException(Long id){
        super("Could not find a product with " + id);
    }
}
