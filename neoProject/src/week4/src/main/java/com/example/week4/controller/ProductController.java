package com.example.week4.controller;


import com.example.week4.entity.Product;
import com.example.week4.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
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

    @PostMapping("/add/admin")
    Product postNewProduct(@RequestBody @Valid Product newProduct){
        return service.postNewProduct(newProduct);
    }
    @PostMapping("/addBulk/admin")
    List<Product> createBulkOfProducts(@RequestBody List<@Valid Product> bulkOfProducts){
        return service.createBulkOfProducts(bulkOfProducts);
    }
    @PutMapping("/updateProduct/user/{id}")
    Product updateProduct(@RequestBody @Valid Product newProduct, @PathVariable Long id){
        return service.updateProduct(newProduct,id);
    }
    @PutMapping("/updateProducts/user")
    List<Product> updateProducts(@RequestParam("ids") List<Long> ids, @RequestBody List<@Valid Product> updatedProducts){
       return service.updateProducts(ids,updatedProducts);
    }
    @DeleteMapping("/admin/{id}")
    void deleteOldProduct(@PathVariable Long id){
        service.deleteOldProduct(id);
    }
    @DeleteMapping("/deleteAll/admin")
    public void deleteAllProducts() {
        service.deleteAllProducts();
    }
}
