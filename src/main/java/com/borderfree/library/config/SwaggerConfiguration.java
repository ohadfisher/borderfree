package com.borderfree.library.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Library API")
                        .description("Copyright &copy; 2021 by Borderfree, Pitney Bowes. " +
                                "The project is for test assignment only. Distribution of the project is prohibited."));
    }
}
