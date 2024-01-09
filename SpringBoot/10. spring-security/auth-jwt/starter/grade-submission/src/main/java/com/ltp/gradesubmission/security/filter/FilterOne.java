package com.ltp.gradesubmission.security.filter;

import java.io.IOException;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class FilterOne implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println(((HttpServletRequest)request).getRequestURI());
        System.out.println("Hey we are in filter one");
        chain.doFilter(request, response);
    }


}

    
  
    

