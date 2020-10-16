package com.meru.offerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.meru.offerservice"))
                .paths(PathSelectors.any()).build();

        // swagger Meta Data JSON http://localhost:8080/v2/api-docs
        // swagger UI URL http://localhost:8080/swagger-ui.html

    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("Promotion Microservice")
                .description("This Page List all API's of Promotion Microservice")
                .contact(new Contact("Suraj Krishan", "https://surajkrishan.github.io", "suraj.krishan@wipro.com"))
                .version("2.0").build();
    }
}
