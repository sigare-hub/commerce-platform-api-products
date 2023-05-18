package com.commerceplatform.api.products.configurations;

import com.commerceplatform.api.products.routes.ProductRoutes;

import com.commerceplatform.api.products.security.JwtService;
import com.commerceplatform.api.products.security.filters.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalAuthentication
@Configuration
public class Configurations {
    private final JwtService jwtService;

    public Configurations(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET, "/product").permitAll()
            .requestMatchers(HttpMethod.POST, ProductRoutes.PRODUCT.getValue()).hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/product").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/product").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET, "/product/products").permitAll()
            .requestMatchers(HttpMethod.GET, "/category").permitAll()
            .requestMatchers(HttpMethod.POST, "/category").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/category").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/category").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET, "/product-category").permitAll()
            .requestMatchers(HttpMethod.POST, "/product-category/**").hasRole("ADMIN")
            .anyRequest().authenticated().and()
            .csrf().disable()
            .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter(jwtService);
    }

}