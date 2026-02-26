package com.diego.springboot.dependecyinjection.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.diego.springboot.dependecyinjection.app.springboot_di.models.Product;

import tools.jackson.databind.ObjectMapper;

public class ProductRepositoyJson implements ProductRepository {
 private List<Product> list;

 public ProductRepositoyJson() {

        ClassPathResource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();    
        }
     

 }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();

    }
 
    
}
