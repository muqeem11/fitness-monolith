package com.project.fitness.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Fitness Tracking API")
                        .version("1.0")
                        .description("This is the Fitness Tracking API")
//                        .contact(new Contact().name("XYZ").url("https://www.fitness.com").emal("")

                );
    }

}
