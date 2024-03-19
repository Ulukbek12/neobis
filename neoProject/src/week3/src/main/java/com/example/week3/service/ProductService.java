package com.example.week3.service;

import com.example.week3.entity.Product;
import com.example.week3.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService( ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProduct(){
        return repository.findAll();
    }


    public Product getOneProduct(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Could not find information about " + id));
    }


        public  Product postNewProduct(Product newProduct){
        return repository.save(newProduct);
    }

        public Product putNewProduct( Product newProduct,Long id){
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

        public void deleteOldProduct( Long id){
        repository.deleteById(id);
    }
}
