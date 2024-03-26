package com.example.week4.controller;


import com.example.week4.entity.Product;
import com.example.week4.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping("/products/{price}")
    public List<Product> getProductsPriceGreaterThan(@PathVariable double price) {
        return service.getProductsPriceGreaterThan(price);
    }

    @PostMapping("/admin")
    Product postNewProduct(@RequestBody @Valid Product newProduct){
        return service.postNewProduct(newProduct);
    }
    @PostMapping("/admin/{bulk}")
    List<Product> createBulkOfProducts(@RequestBody List<@Valid Product> bulkOfProducts){
        return service.createBulkOfProducts(bulkOfProducts);
    }
    @PutMapping("/admin/{id}")
    Product updateProduct(@RequestBody @Valid Product newProduct, @PathVariable Long id){
        return service.updateProduct(newProduct,id);
    }
    @PutMapping("/admin")
    List<Product> updateProducts(@RequestParam("ids") List<Long> ids, @RequestBody List<@Valid Product> updatedProducts){
       return service.updateProducts(ids,updatedProducts);
    }
    @DeleteMapping("/admin/{id}")
    void deleteOldProduct(@PathVariable Long id){
        service.deleteOldProduct(id);
    }
    @DeleteMapping("/admin")
    public void deleteAllProducts() {
        service.deleteAllProducts();
    }
}
