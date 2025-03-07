package com.aperegarc.SpringBoot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Deshabilita CSRF (opcional, solo si no usas formularios)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/**").authenticated()  // Solo autenticados pueden hacer GET
                .requestMatchers(HttpMethod.POST, "/**").authenticated() // Permite POST solo a autenticados
                .requestMatchers(HttpMethod.DELETE, "/**").authenticated() // Permite DELETE solo a autenticados
                .anyRequest().permitAll() // Otras rutas quedan abiertas
            )
            .httpBasic(); // Usa autenticación básica (usuario/contraseña en el header)
        
        return http.build();
    }

}
