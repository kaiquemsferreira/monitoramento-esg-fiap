package com.projeto_fiap.monitoramento_esg.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ESG Energy Monitoring API")
                        .description("API REST para monitoramento de sensores de consumo energético e alertas de consumo excessivo")
                        .description("Projeto com o intuito acadêmico referente a um projeto da Faculdade de Informática e Administração Paulista (FIAP)")
                        .version("1.0")
                        .contact(new Contact().name("Kaique Martins da Silva Ferreira").email("kaiquemartinsdasilvaferreira@gmail.com"))
                        .contact(new Contact().name("Henrique de Novaes").email("rick.novaes10@gmail.com"))
                        .contact(new Contact().name("Mauricio Dias Gonçalves").email("mauriciodiasgoncalves@gmail.com"))
                        .license(new License().name("Uso acadêmico")));
    }
}
