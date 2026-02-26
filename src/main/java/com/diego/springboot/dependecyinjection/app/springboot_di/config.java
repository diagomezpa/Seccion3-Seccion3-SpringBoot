package com.diego.springboot.dependecyinjection.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.diego.springboot.dependecyinjection.app.springboot_di.repositories.ProductRepository;
import com.diego.springboot.dependecyinjection.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({
	@PropertySource(value = "classpath:config.properties", encoding = "UTF-8"),
	
})

public class config {

    @Value("classpath:json/product.json")
 private Resource resource;

    // esta es una forma de registrar un bean en el contenedor de spring, es una forma manual de registrar un bean, se recomienda usar esta forma cuando queremos registrar un bean que no es una clase anotada con @Component, @Service, @Repository o @Controller, por ejemplo, si queremos registrar un bean que es una clase de una librería externa que no tiene anotaciones de spring, podemos usar esta forma para registrar ese bean en el contenedor de spring y luego inyectarlo en nuestros controladores o servicios sin necesidad de modificar el código de la clase de la librería externa, esto hace que el código sea más limpio y fácil de mantener, además, permite registrar beans con configuraciones específicas, por ejemplo, si queremos registrar un bean con un scope específico o con un nombre específico, podemos usar esta forma para configurar ese bean de acuerdo a nuestras necesidades
    @Bean("productJson")
    public ProductRepository productRepositoyJson() {
        //return new ProductRepositoryJson(resource);
        return new ProductRepositoryJson();
    }


}
