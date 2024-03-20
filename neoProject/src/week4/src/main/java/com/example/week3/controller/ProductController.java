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
    List<Product> getAllProduct(){
        return service.getAllProduct();
    }

    @GetMapping("/products/{id}")
    Product getOneProduct(@PathVariable Long id){
        return service.getOneProduct(id);
    }
    @GetMapping("/priceGreaterThan/{price}")
    public List<Product> getProductsPriceGreaterThan(@PathVariable double price) {
        return service.getProductsPriceGreaterThan(price);
    }

    @PostMapping("/products")
    Product postNewProduct(@RequestBody Product newProduct){
        return service.postNewProduct(newProduct);
    }
    @PostMapping("/products/{bulk}")
    List<Product> createBulkOfProducts(@RequestBody List<Product> bulkOfProducts){
        return service.createBulkOfProducts(bulkOfProducts);
    }
    @PutMapping("/products/{id}")
    Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id){
        return service.updateProduct(newProduct,id);
    }
    @PutMapping("/products")
    List<Product> updateProducts(@RequestParam("ids") List<Long> ids, @RequestBody List<Product> updatedProducts){
       return service.updateProducts(ids,updatedProducts);
    }
    @DeleteMapping("/products/{id}")
    void deleteOldProduct(@PathVariable Long id){
        service.deleteOldProduct(id);
    }
    @DeleteMapping("/products")
    public void deleteAllProducts() {
        service.deleteAllProducts();
    }
}
