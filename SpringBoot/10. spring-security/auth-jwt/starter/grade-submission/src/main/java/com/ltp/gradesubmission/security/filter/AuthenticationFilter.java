package com.ltp.gradesubmission.security.filter;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.gradesubmission.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
             
        try {
            User user= new ObjectMapper().readValue(request.getInputStream(),User.class);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
        } catch (IOException e) {
           throw new RuntimeException();
        }        

        return super.attemptAuthentication(request, response);
    }
}
