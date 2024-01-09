package com.ltp.gradesubmission.security.filter;


    import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.gradesubmission.entity.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

 public class FilterTwo  implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        User user= new ObjectMapper().readValue(request.getInputStream(),User.class);

        
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }


}

    

