package com.skillsphere.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // Disable CSRF
                .csrf(csrf -> csrf.disable())

                // Authorization Rules
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/api/**",
                                "/actuator/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )

                // Disable Login Page
                .formLogin(form -> form.disable())

                // Disable HTTP Basic Login Popup
                .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }
}