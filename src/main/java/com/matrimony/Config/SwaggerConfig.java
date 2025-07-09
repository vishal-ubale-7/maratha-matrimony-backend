package com.matrimony.Config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig
{
    @Bean
    public OpenAPI customOpenAPI()
    {
        return new OpenAPI()
                .info(new Info()
                        .title("Maratha Matrimony API")
                        .version("1.0")
                        .description("This is the API documentation for the Maratha Matrimony project")
                        .contact(new Contact()
                                .name("Vishal Ubale")
                                .email("vishal@example.com")));
    }
}


