package org.avmp.apiexample.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setUrl("https://github.com/MinAnnie/spring-api-docker");
        myContact.setName("Angie Matiz");
        myContact.setEmail("matizangie6@gmail.com");

        Info information = new Info()
                .title("Ejemplo de API REST con Docker")
                .version("1.0")
                .description("Ejemplo de API REST con Docker")
                .contact(myContact);

        return new OpenAPI().info(information).servers(List.of(server));
    }
}
