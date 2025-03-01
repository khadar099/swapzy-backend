package com.swapzy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    // Security configuration using SecurityFilterChain (no WebSecurityConfigurerAdapter)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login", "/register").permitAll() // Allow access to login and register pages
                .anyRequest().authenticated() // All other requests require authentication
            .and()
            .formLogin().loginPage("/login") // Set custom login page
            .and()
            .logout().permitAll(); // Allow logout for all users

        return http.build();
    }

    // A simple in-memory UserDetailsService for demo purposes
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            if ("admin".equals(username)) {
                return User.withUsername("admin")
                    .password(passwordEncoder().encode("password"))
                    .roles("ADMIN")
                    .build();
            }
            throw new UsernameNotFoundException("User not found");
        };
    }

    // Password encoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
