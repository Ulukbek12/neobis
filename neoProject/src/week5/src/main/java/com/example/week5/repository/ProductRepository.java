package com.example.week5.repository;

import com.example.week5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByPriceGreaterThan(double price);

}
