package com.example.week5.interfaces;

import com.example.week5.entity.Product;

import java.util.List;

public interface ProductServices {
    List<Product> getAllProduct();
    Product getOneProduct(Long id);
    List<Product> getProductsPriceGreaterThan(double price);
    List<Product> createBulkOfProducts(List<Product> bulk);
    Product postNewProduct(Product newProduct);
    Product updateProduct(Product newProduct,Long id);
    List<Product> updateProducts(List<Long> ids, List< Product> updatedProducts);
    void deleteOldProduct(Long id);
    void deleteAllProducts();
}
