package com.logsoluprobl.appbank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI bankAppOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mi app de banco")
                        .description("Esta es la descripcion del proyecto")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Samuel Perez")
                                .email("email@ejemplo.com")
                                .url("https://url.ejemplo.com"))
                        .license(new License()
                                .name("Nombre licencia")
                                .url("http://ejemplo.licencia.com")));
    }
}