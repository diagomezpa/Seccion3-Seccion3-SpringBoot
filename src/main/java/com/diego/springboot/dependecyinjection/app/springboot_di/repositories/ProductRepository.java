package com.diego.springboot.dependecyinjection.app.springboot_di.repositories;

import java.util.List;

import com.diego.springboot.dependecyinjection.app.springboot_di.models.Product;

public interface ProductRepository {

    List<Product> findAll();
    Product findById(Long id);


}
