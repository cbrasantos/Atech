package br.com.atech.empresaarea.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class Swagger2Config {

    private final static String PACKAGE_SERVICE_REST = "br.com.atech.empresaaerea.web.rest.controller";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_SERVICE_REST))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("API Empresa Aerea - Teste DevOps Atech", "Serviços para integração de Empresa Aerea", "1.0.0", "",
                new Contact("Cleber Alexandre dos Santos", "", "cbr.asantos@gmail.com.br"), "", "", Collections.emptyList());
        return apiInfo;
    }

}
