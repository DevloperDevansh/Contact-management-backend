package com.spring.contactManagerApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Marks this class as a configuration class — it will be automatically loaded at runtime
@Configuration
public class WebConfig {

    // Defines a bean that customizes the Spring MVC configuration
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            // This method configures Cross-Origin Resource Sharing (CORS)
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Apply this CORS configuration to all backend endpoints
                        .allowedOrigins("http://localhost:3000") // Allow requests only from React app running on port 3000
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these HTTP methods
                        .allowedHeaders("*"); // Allow all headers (like Content-Type, Authorization, etc.)
            }
        };
    }
}

