package com.official_dealer.auto.security;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/v3/api-docs.yaml")
                        .permitAll()

                        .requestMatchers("/api/public/**").permitAll()
                        .requestMatchers("/api/dealer/**").hasRole("DEALER")
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")

                        .anyRequest().authenticated())
                .httpBasic();

        return http.build();
    }
}
// @Bean
// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

// http
// .csrf(csrf -> csrf.disable())
// .authorizeHttpRequests(auth -> auth
// .requestMatchers("/api/public/**").permitAll()
// .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
// .requestMatchers("/api/dealer/**").hasRole("DEALER")
// .anyRequest().authenticated()
// )
// .httpBasic(); // временно, для простоты

// return http.build();
// }
// }
