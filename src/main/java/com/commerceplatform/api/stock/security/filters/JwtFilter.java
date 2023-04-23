package com.commerceplatform.api.stock.security.filters;

import com.commerceplatform.api.stock.security.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String token = getHeaderToken(request);
        if(token != null) {
            authenticateByToken(token);
        }
        filterChain.doFilter(request, response);
    }

    private void authenticateByToken(String token) {
//        try {
//            var subject = this.jwtService.getSubject(token);
//            var user = userRepository.findByEmail(subject);
//
//            SecurityContextHolder
//                    .getContext()
//                    .setAuthentication(new UsernamePasswordAuthenticationToken(
//                                    user,
//                                    null,
//                                    user.get().getAuthorities()
//                            )
//                    );
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }

    }

    private String getHeaderToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return null;
        }
        return authorizationHeader.substring(7);
    }
}