package com.gdgline.mulmung.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Mulmung Backend API",
                version = "1.0",
                description = "GDG 비전첼린지 \\\"GDGline\\\"팀 Mulmung API 명세서 입니다."
        )
)
public class SwaggerConfig {
}
