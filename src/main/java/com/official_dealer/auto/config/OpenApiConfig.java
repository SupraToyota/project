package com.official_dealer.auto.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    // @Bean
    // public OpenAPI openAPI() {
    //     return new OpenAPI()
    //             .info(new Info()
    //                     .title("Official Dealer Auto API")
    //                     .version("v1")
    //                     .description("Backend API for official auto dealers platform"));
    // }

    @Bean
    public OpenAPI openAPI() {
    return new OpenAPI()
            .components(new Components()
                .addSecuritySchemes("basicScheme",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("basic")))
            .info(new Info()
                .title("Official Dealer Auto API")
                .version("v1")
                .description("Backend API for official auto dealers platform"));
}


}
