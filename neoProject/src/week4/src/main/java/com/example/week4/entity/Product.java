package com.example.week4.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(name = "name")
    @NotBlank
    private String name;
    @Column(name = "price",nullable = false)
    private double price;

    @Column(name = "description")
    @NotBlank
    private String description;

    public Product() {
    }

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
