package com.diego.springboot.dependecyinjection.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.diego.springboot.dependecyinjection.app.springboot_di.models.Product;


@Primary
@Repository("productList") // un reporsitori es un mecanismo para encapsular el almacenamiento, recuperación y búsqueda de objetos, es una capa de abstracción entre la aplicación y la base de datos, se encarga de manejar la lógica de acceso a datos, en este caso es una implementación en memoria, pero en una aplicación real podría ser una implementación que acceda a una base de datos relacional o no relacional, se recomienda usar la anotación @Repository para marcar esta clase como un repositorio, esto permite a spring manejar las excepciones de acceso a datos y traducirlas a excepciones de spring, además de permitir la inyección de dependencias en esta clase si es necesario
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
