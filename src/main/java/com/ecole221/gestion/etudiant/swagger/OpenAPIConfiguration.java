package com.ecole221.gestion.etudiant.swagger;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SecurityScheme(
        name = "Authorization",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi(){
        Server server = new Server();
        server.url("http://localhost:8083");
        server.description("Developpement d'un api avec authentification et autorisation");

        Contact contact = new Contact();
        contact.setName("Baye Niass");
        contact.setName("bniass@gmail.com");

        Info info = new Info()
        .title("Gestion scolarité")
        .version("1.0")
        .description("Cette api permet de gérer un établissement scolaire")
        .contact(contact) ;
        return  new OpenAPI().info(info).servers(List.of(server));
    }
}
