package com.sonera1.stockmanagement.productservice.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api(){// for documantion plugin

        return new Docket(DocumentationType.SWAGGER_2)
                .select() // controller to endpoints
                .apis(RequestHandlerSelectors.basePackage("com.sonera1")) // search apis for this package
                .paths(PathSelectors.any()) // all make apis doc.
                .build();
    }

}
