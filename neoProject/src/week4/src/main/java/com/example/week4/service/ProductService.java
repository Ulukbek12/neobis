package com.example.week4.service;

import com.example.week4.entity.Product;
import com.example.week4.exception.ProductNotFoundException;
import com.example.week4.repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    public List<Product> getAllProduct() {
        return repository.findAll();
    }
    public Product getOneProduct(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
    public List<Product> getProductsPriceGreaterThan(double price){
        return repository.findByPriceGreaterThan(price);
    }
    public List<Product> createBulkOfProducts(List<Product> bulk){
        return repository.saveAll(bulk);
    }
    public  Product postNewProduct(Product newProduct){
        return repository.save(newProduct);
    }

    public Product updateProduct(Product newProduct,Long id){
        return repository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    product.setDescription(newProduct.getDescription());
                    return repository.save(product);
                })
                .orElseThrow(()-> new ProductNotFoundException(id));
    }
    public List<Product> updateProducts(List<Long> ids, List< Product> updatedProducts){
        List<Product> updatedProductsList = new ArrayList<>();
        for(int i = 0; i < ids.size();i++){
            Long id = ids.get(i);
            Product updatedProduct = updatedProducts.get(i);
            updatedProductsList.add(updateProduct(updatedProduct,id));
        }
        return updatedProductsList;
    }
    public void deleteOldProduct(Long id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }else{
            throw new ProductNotFoundException(id);
        }
    }
    public void deleteAllProducts() {
        repository.deleteAll();
    }
}
