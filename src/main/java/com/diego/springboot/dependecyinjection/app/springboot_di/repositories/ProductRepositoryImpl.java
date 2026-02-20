package com.diego.springboot.dependecyinjection.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.diego.springboot.dependecyinjection.app.springboot_di.models.Product;

public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair 32", 300L),
                new Product(2L, "Disco duro SSD 1TB", 150L),
                new Product(3L, "Monitor LG 24\"", 200L));
    }

    @Override
    public List<Product> findAll() {
        return this.data;
    }

    @Override
    public Product findById(Long id) {
        return this.data.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
