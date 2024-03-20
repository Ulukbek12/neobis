package com.example.week3.repository;

import com.example.week3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    //It automatically generates sql query to fetch product that are greater than
    List<Product> findByPriceGreaterThan(double price);

}
