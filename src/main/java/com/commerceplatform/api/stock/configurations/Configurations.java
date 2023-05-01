package com.commerceplatform.api.stock.configurations;

import com.commerceplatform.api.stock.routes.ProductRoutes;
import com.commerceplatform.api.stock.security.CustomUserDetailsService;
import com.commerceplatform.api.stock.security.JwtService;
import com.commerceplatform.api.stock.security.filters.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalAuthentication
@Configuration
public class Configurations {
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtService jwtService;

    public Configurations(CustomUserDetailsService customUserDetailsService, JwtService jwtService) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtService = jwtService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(customUserDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeHttpRequests()
            .requestMatchers(HttpMethod.POST, ProductRoutes.PRODUCT.getValue()).hasRole("ADMIN")
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