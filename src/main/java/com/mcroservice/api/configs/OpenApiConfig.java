package com.mcroservice.api.configs;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;




@Configuration
@OpenAPIDefinition(
        info = @Info(
            title = "API DE PRUEBA ",
                version = "1.0.0.0",
                description = "Microservice - para Visualizar los pagos pendientes"
        )
)
public class OpenApiConfig {
	
	
	
	
}
