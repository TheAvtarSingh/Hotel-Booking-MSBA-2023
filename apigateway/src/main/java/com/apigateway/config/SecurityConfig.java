package com.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        try {
            http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(authorizeExchange ->
                    authorizeExchange
                        .pathMatchers(HttpMethod.POST, "/gateway/**").hasRole("USER")
                        .anyExchange().authenticated()
                )
                .httpBasic(withDefaults()); // Assuming you are using HTTP Basic Authentication
            return http.build();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.builder()
                .username("miniproject")
                .password("{noop}miniproject0001")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
