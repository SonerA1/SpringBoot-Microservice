package com.sonera1.stockmanagement.productservice.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //
@EnableSwagger2 // swagger için
public class SwaggerConfiguration {

    @Bean
    public Docket api(){ // docket documantion implemente eder// eğer daha sonrası için dökuman gerek olursa
        return  new Docket(DocumentationType.SWAGGER_2).select() // select metodu swager tarafından sunulan endpointleri kontrol etmeye yarar
                .apis(RequestHandlerSelectors.basePackage("com.sonera1")) // apileri bu paket altında ara demek
                .paths(PathSelectors.any())// buda tanımladığımız tüm api tanımlamalarını oluştur demek.
                .build();//

    }

}
