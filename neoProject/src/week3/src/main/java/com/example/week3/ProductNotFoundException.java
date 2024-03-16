package com.example.week3;

public class ProductNotFoundException extends RuntimeException{
    ProductNotFoundException(Long id){
        super("Could not find information about " + id);
    }
}
