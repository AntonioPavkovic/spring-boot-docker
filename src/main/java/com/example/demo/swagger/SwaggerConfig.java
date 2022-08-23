package com.example.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/v1/**"))
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .build().apiInfo(apiDetails());

    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Simple CRUD API",
                "Spring Boot and Docker learning",
                "1.0",
                "free to use",
                new springfox.documentation.service.Contact("Antonio Pavkovic", "https://fsre.sum.ba/", "antonio.pavkovic@fsre.sum.ba"),
                "API Licence",
                "https://fsre.sum.ba/",
                Collections.emptyList()
        );
    }
}
