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

    private static final String PRODUCT_ROUTE = "/product";
    private static final String CATEGORY_ROUTE = "/category";
    private static final String ROLE_ADMIN = "ADMIN";

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
            .requestMatchers(HttpMethod.GET, PRODUCT_ROUTE).permitAll()
            .requestMatchers(HttpMethod.POST, ProductRoutes.PRODUCT.getValue()).hasRole(ROLE_ADMIN)
            .requestMatchers(HttpMethod.PUT, PRODUCT_ROUTE).hasRole(ROLE_ADMIN)
            .requestMatchers(HttpMethod.DELETE, PRODUCT_ROUTE).hasRole(ROLE_ADMIN)
            .requestMatchers(HttpMethod.GET, "/product/by-ids").permitAll()
            .requestMatchers(HttpMethod.GET, CATEGORY_ROUTE).permitAll()
            .requestMatchers(HttpMethod.POST, CATEGORY_ROUTE).hasRole(ROLE_ADMIN)
            .requestMatchers(HttpMethod.PUT, CATEGORY_ROUTE).hasRole(ROLE_ADMIN)
            .requestMatchers(HttpMethod.DELETE, CATEGORY_ROUTE).hasRole(ROLE_ADMIN)
            .requestMatchers(HttpMethod.GET, "/product-category").permitAll()
            .requestMatchers(HttpMethod.POST, "/product-category/**").hasRole(ROLE_ADMIN)
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