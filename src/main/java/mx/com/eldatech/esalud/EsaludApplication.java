package mx.com.eldatech.esalud;

import mx.com.eldatech.esalud.enums.Enums;
import mx.com.eldatech.esalud.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class EsaludApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsaludApplication.class, args);
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityconfig {

        @Value("${application.jwk}")
        private String jwk;
        @Value("${application.cipher.key}")
        private String cipherKey;

        @Bean
        protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf
                    .disable()).addFilterAfter(new JWTAuthorizationFilter(jwk,cipherKey), UsernamePasswordAuthenticationFilter.class);
            http
                    .authorizeHttpRequests((authorize) -> authorize
                    .requestMatchers(Enums.AUTH_WHITELIST).permitAll()
                    .requestMatchers("/**").authenticated());
            return http.build();
        }
    }

}
