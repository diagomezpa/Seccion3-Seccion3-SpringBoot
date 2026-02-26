package com.diego.springboot.dependecyinjection.app.springboot_di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource(value = "classpath:config.properties", encoding = "UTF-8"),
	
})

public class config {


}
