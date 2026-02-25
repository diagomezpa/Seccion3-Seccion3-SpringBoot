package com.diego.springboot.dependecyinjection.app.springboot_di.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.springboot.dependecyinjection.app.springboot_di.models.Product;
import com.diego.springboot.dependecyinjection.app.springboot_di.services.ProductService;
import com.diego.springboot.dependecyinjection.app.springboot_di.services.ProductServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired // // spring va a buscar una implementacion de la interfaz ProductService, en este caso ProductServiceImpl, y la va a inyectar en el controlador, no es necesario crear una instancia de ProductServiceImpl, spring se encarga de eso, se recomienda usar la interfaz en lugar de la implementación para cumplir con el principio de inversión de dependencias, es decir, depender de abstracciones en lugar de concretos, esto hace que el código sea más flexible y fácil de mantener, si queremos cambiar la implementación de ProductService, solo tenemos que cambiar la anotación @Component en la nueva implementación y spring se encargará de inyectarla en el controlador sin necesidad de modificar el código del controlador
    private ProductService productService;

    // puede hacer injeccion por constructor, por setter o por campo, la injeccion por constructor es la forma recomendada, ya que permite declarar las dependencias de la clase de forma explícita, lo que facilita la lectura y el mantenimiento del código, además, permite inyectar dependencias finales, lo que mejora la seguridad del código, si una dependencia es final, no puede ser modificada después de ser inyectada, lo que garantiza que la clase siempre tenga una instancia válida de la dependencia
    // public SomeController(ProductService productService) {
    //     this.productService = productService;
    // }

    @GetMapping
    public List<Product> list() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return this.productService.findById(id);
    }

}
