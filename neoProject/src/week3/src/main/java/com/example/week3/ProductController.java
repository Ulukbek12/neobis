package com.example.week3;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Product> all(){
        return repository.findAll();
    }

    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct){
        return repository.save(newProduct);
    }
    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id){
    return repository.findById(id)
            .map(product -> {
                product.setName(newProduct.getName());
                product.setPrice(newProduct.getPrice());
                product.setDescription(newProduct.getDescription());
                return repository.save(product);
            })
            .orElseGet(()->{
                newProduct.setId(id);
                return repository.save(newProduct);
            });
    }
    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
    }
}
