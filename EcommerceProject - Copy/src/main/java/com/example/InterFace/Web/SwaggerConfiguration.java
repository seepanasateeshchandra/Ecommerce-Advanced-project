package com.example.InterFace.Web;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

@Configuration
@OpenAPIDefinition(
    info = @Info(title = "Ecommerce API", version = "1.0"),
    security = @SecurityRequirement(name = "bearerAuth")  // Apply to all endpoints
)
@SecurityScheme(
    name = "bearerAuth",
    scheme = "bearer",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT"  // Important: must be "JWT"
)

public class SwaggerConfiguration {

}
