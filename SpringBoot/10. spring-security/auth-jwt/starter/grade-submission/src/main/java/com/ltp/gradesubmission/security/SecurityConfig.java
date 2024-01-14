package com.ltp.gradesubmission.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.ltp.gradesubmission.security.filter.AuthenticationFilter;
import com.ltp.gradesubmission.security.filter.ExceptionHandlerFilter;
import com.ltp.gradesubmission.security.filter.JWTAuthorizationFilter;
import com.ltp.gradesubmission.security.manager.CustomAuthenticationManager;




@Configuration
@EnableWebSecurity
public class SecurityConfig {

    CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/authenticate");
        http
            .headers(headers -> headers
                .frameOptions().disable() // Disable frame options
            )
            .csrf().disable()
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/h2/**").permitAll() // Allow access to h2 console without authentication
                    .requestMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()
                    .anyRequest().authenticated()
                    
            )
            .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
            .addFilter(new AuthenticationFilter(customAuthenticationManager))
            .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
            .sessionManagement(sessionManagement ->
                sessionManagement
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

        return http.build();
    }
}
