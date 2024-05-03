package com.rafael.demo.APIWeb.infra.Security;

import com.rafael.demo.APIWeb.infra.token.TokenService;
import com.rafael.demo.APIWeb.user.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService service;
    @Autowired
    private UserRepository repository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = recoverToken(request);
        if(tokenJWT != null){
            String subject = service.getSubject(tokenJWT);
            UserDetails user = repository.findByLogin(subject);
            var authentication = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request,response);
    }

    private String recoverToken(HttpServletRequest request) {
        String token =  request.getHeader("Authorization");
        if(token != null){
            return token.replace("Bearer ","");
        }
        return null;
    }
}
