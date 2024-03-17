/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.eldatech.esalud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author apioconsulting
 */
@Configuration
public class CrossOriginConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerImpl();
    }

    private static class WebMvcConfigurerImpl implements WebMvcConfigurer {

        public WebMvcConfigurerImpl() {
        }

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:4200","http://127.0.0.1:8080","http://localhost:8080")
                    .allowedMethods("GET","POST")
                    .allowCredentials(true);
        }
    }
}
