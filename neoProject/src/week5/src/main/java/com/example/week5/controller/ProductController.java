package com.example.week5.controller;


import com.example.week5.entity.Product;
import com.example.week5.service.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductController {
     ProductService service;

    @GetMapping()
    List<Product> getAllProduct(){
        return service.getAllProduct();
    }
    @GetMapping("/{id}")
    Product getOneProduct(@PathVariable Long id){
        return service.getOneProduct(id);
    }
    @GetMapping("/greaterThan/{price}")
    public List<Product> getProductsPriceGreaterThan(@PathVariable double price) {
        return service.getProductsPriceGreaterThan(price);
    }

    @PostMapping("/add")
    Product postNewProduct(@RequestBody @Valid Product newProduct){
        return service.postNewProduct(newProduct);
    }
    @PostMapping("/addBulk")
    List<Product> createBulkOfProducts(@RequestBody List<@Valid Product> bulkOfProducts){
        return service.createBulkOfProducts(bulkOfProducts);
    }
    @PutMapping("/updateProduct/{id}")
    Product updateProduct(@RequestBody @Valid Product newProduct, @PathVariable Long id){
        return service.updateProduct(newProduct,id);
    }
    @PutMapping("/updateProducts")
    List<Product> updateProducts(@RequestParam("ids") List<Long> ids, @RequestBody List<@Valid Product> updatedProducts){
       return service.updateProducts(ids,updatedProducts);
    }
    @DeleteMapping("/{id}")
    public void deleteOldProduct(@PathVariable Long id){
        service.deleteOldProduct(id);
    }
    @DeleteMapping("/deleteAll")
    public void deleteAllProducts() {
        service.deleteAllProducts();
    }
}
