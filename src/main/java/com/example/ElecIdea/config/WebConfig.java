
package com.example.ElecIdea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Aplica CORS solo a las rutas que comienzan con /api/
                .allowedOrigins("*") // Asegúrate de que el puerto coincida con el de tu servidor frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Permite estos métodos
    }
}
