package com.diego.springboot.dependecyinjection.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.diego.springboot.dependecyinjection.app.springboot_di.models.Product;
//@Primary // esta anotacion indica que esta es la implementacion principal de la interfaz ProductRepository, si hay varias implementaciones de la interfaz ProductRepository, spring va a inyectar esta implementacion en lugar de las otras, se recomienda usar esta anotacion cuando hay varias implementaciones de una interfaz, para evitar confusiones y errores al inyectar dependencias, si no se usa esta anotacion, spring va a lanzar una excepcion indicando que hay varias implementaciones de la interfaz ProductRepository y no sabe cual inyectar, con esta anotacion, spring va a inyectar esta implementacion sin necesidad de especificar el nombre de la clase o el paquete donde se encuentra la clase, lo que hace que el código sea más limpio y fácil de mantener
@Repository("productAlt")
public class ProductRepositoryAltImpl implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600L));

    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Monitor Asus 27", 600L);
    }

}
