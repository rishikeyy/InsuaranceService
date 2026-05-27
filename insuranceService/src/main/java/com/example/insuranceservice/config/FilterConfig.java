package com.example.insuranceservice.config;

import com.example.insuranceservice.filter.JwtAuthenticationFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter>
    jwtFilter() {

        FilterRegistrationBean<JwtAuthenticationFilter> registration =
                new FilterRegistrationBean<>();

        registration.setFilter(new JwtAuthenticationFilter());

        registration.addUrlPatterns("/*");

        return registration;
    }
}