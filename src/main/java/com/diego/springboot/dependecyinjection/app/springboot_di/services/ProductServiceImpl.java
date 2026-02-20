package com.diego.springboot.dependecyinjection.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.diego.springboot.dependecyinjection.app.springboot_di.models.Product;
import com.diego.springboot.dependecyinjection.app.springboot_di.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    public Product findById(Long id) {
        return this.repository.findById(id);
    }

    // public List<Product> findAll() { // el set no cumple con principio de inmutabilidad, se modifica el objeto original, no es recomendable
    //     return this.repository.findAll().stream().map(p -> {
    //         Double priceImp = p.getPrice() * 1.25d;
    //         p.setPrice(priceImp.longValue());
    //         return p;
    //     }).collect(Collectors.toList());
    // }

    public List<Product> findAll() { // el map crea un nuevo objeto, no modifica el original, cumple con principio de inmutabilidad, es recomendable
    return this.repository.findAll()
        .stream()
        .map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            // return new Product(
            //     p.getId(),
            //     p.getName(),
            //     priceImp.longValue()
            // );
            Product clonedProduct = p.clone();
            clonedProduct.setPrice(priceImp.longValue());
            return clonedProduct; // se clona el objeto original, se modifica el precio del nuevo objeto, no se modifica el original, cumple con principio de inmutabilidad, es recomendable
        })
        .collect(Collectors.toList());
}

}
