package com.diego.springboot.dependecyinjection.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.diego.springboot.dependecyinjection.app.springboot_di.models.Product;
import com.diego.springboot.dependecyinjection.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public Product findById(Long id) {
        return this.repository.findById(id);
    }

    public List<Product> findAll() {
        return this.repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            p.setPrice(priceImp.longValue());
            return p;
        }).collect(Collectors.toList());
    }

}
