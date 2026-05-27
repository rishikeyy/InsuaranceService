package com.example.insuranceservice.filter;

import com.example.insuranceservice.util.JwtValidator;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JwtAuthenticationFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse res =
                (HttpServletResponse) response;

        String path = req.getRequestURI();

        // Public endpoint
        if (path.startsWith("/viewOffers")) {

            chain.doFilter(request, response);
            return;
        }

        String authHeader =
                req.getHeader("Authorization");

        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String token =
                authHeader.substring(7);

        boolean valid =
                JwtValidator.validate(token);

        if (!valid) {

            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        chain.doFilter(request, response);
    }
}