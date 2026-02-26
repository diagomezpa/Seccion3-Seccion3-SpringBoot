package com.diego.springboot.dependecyinjection.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.diego.springboot.dependecyinjection.app.springboot_di.models.Product;
import com.diego.springboot.dependecyinjection.app.springboot_di.repositories.ProductRepository;
import com.diego.springboot.dependecyinjection.app.springboot_di.repositories.ProductRepositoryImpl;


@Service
public class ProductServiceImpl implements ProductService {

    @Value("${config.percertages}")
    private Double percentage;


    //@Autowired
    //@Qualifier("productList") // esta anotacion se usa para especificar cual es la implementacion de la interfaz ProductRepository que se va a inyectar, en este caso se va a inyectar la implementacion ProductRepositoryImpl, si no se especifica esta anotacion, spring va a lanzar una excepcion indicando que hay varias implementaciones de la interfaz ProductRepository y no sabe cual inyectar, con esta anotacion, spring va a inyectar la implementacion especificada sin necesidad de modificar el código del controlador, lo que hace que el código sea más limpio y fácil de mantener, si queremos cambiar la implementación de ProductRepository, solo tenemos que cambiar el valor de esta anotación y spring se encargará de inyectar la nueva implementación sin necesidad de modificar el código del controlador
    private ProductRepository repository ;

    // @Autowired
    // public void setRepository(ProductRepository repository) {
    //     this.repository = repository;
    // }

    
    

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

     //por constructor, es la forma recomendada de inyectar dependencias, ya que permite declarar las dependencias de la clase de forma explícita, lo que facilita la lectura y el mantenimiento del código, además, permite inyectar dependencias finales, lo que mejora la seguridad del código, si una dependencia es final, no puede ser modificada después de ser inyectada, lo que garantiza que la clase siempre tenga una instancia válida de la dependencia
    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() { // el map crea un nuevo objeto, no modifica el original, cumple con principio de inmutabilidad, es recomendable
    return this.repository.findAll()
        .stream()
        .map(p -> {
            Double priceImp = p.getPrice() * this.percentage;
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
