package com.example.week4.controller;


import com.example.week4.entity.Product;
import com.example.week4.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/user")
    List<Product> getAllProduct(){
        return service.getAllProduct();
    }
    @GetMapping("/user/{id}")
    Product getOneProduct(@PathVariable Long id){
        return service.getOneProduct(id);
    }
    @GetMapping("/user/greaterThan/{price}")
    public List<Product> getProductsPriceGreaterThan(@PathVariable double price) {
        return service.getProductsPriceGreaterThan(price);
    }

    @PostMapping("/admin/add")
    Product postNewProduct(@RequestBody @Valid Product newProduct){
        return service.postNewProduct(newProduct);
    }
    @PostMapping("/admin/addBulk")
    List<Product> createBulkOfProducts(@RequestBody List<@Valid Product> bulkOfProducts){
        return service.createBulkOfProducts(bulkOfProducts);
    }
    @PutMapping("/user/updateProduct/{id}")
    Product updateProduct(@RequestBody @Valid Product newProduct, @PathVariable Long id){
        return service.updateProduct(newProduct,id);
    }
    @PutMapping("/user/updateProducts")
    List<Product> updateProducts(@RequestParam("ids") List<Long> ids, @RequestBody List<@Valid Product> updatedProducts){
       return service.updateProducts(ids,updatedProducts);
    }
    @DeleteMapping("/admin/{id}")
    void deleteOldProduct(@PathVariable Long id){
        service.deleteOldProduct(id);
    }
    @DeleteMapping("/admin/deleteAll")
    public void deleteAllProducts() {
        service.deleteAllProducts();
    }
}
