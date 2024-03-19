package com.example.week3.controller;


import com.example.week3.entity.Product;
import com.example.week3.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    List<Product> all(){
        return service.getAllProduct();
    }

    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id){
        return service.getOneProduct(id);
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct){
        return service.postNewProduct(newProduct);
    }
    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id){
        return service.putNewProduct(newProduct,id);
    }
    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id){
        service.deleteOldProduct(id);
    }
}
