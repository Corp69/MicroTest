package com.mcroservice.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class ServiceTestApplication {

public static void main(String[] args) {SpringApplication.run(ServiceTestApplication.class, args);}

@Bean
public OpenAPI customAPI() {
    return new OpenAPI()
            .info(new Info()
                    .title("Test")
                    .version("v1")
                    .description("Test app microservice")
                    .termsOfService("http://swagger.io/terms/")
                    .license(new License().name("Apache 2.0").url("http://springdoc.org")));
}
	
}
