package br.com.desafio.cursos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Cursos API",
                version = "1.0",
                description = "API para gerenciamento de cursos",
                contact = @Contact(
                        name = "Ueder Carlos Costa Caetano",
                        email = "uedercosta@gmail.com",
                        url = "https://github.com/uederdev"
                ),
                license = @License(
                        name = "",
                        url = ""
                ),
                termsOfService = "https://github.com/uederdev"
        )
)
public class CursosApplication {

    public static void main(String[] args) {
        SpringApplication.run(CursosApplication.class, args);
    }

}
