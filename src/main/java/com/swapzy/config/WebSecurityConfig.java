package com.swapzy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    // Bean to encode passwords
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuring HTTP security
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()  // Replaced .authorizeRequests() in Spring Security 6
                .requestMatchers("/register", "/login").permitAll() // Allow registration and login pages
                .anyRequest().authenticated() // Require authentication for all other pages
            .and()
            .formLogin()
                .loginPage("/login") // Set custom login page
                .permitAll() // Allow everyone to access the login page
            .and()
            .logout()
                .permitAll(); // Allow logout for everyone

        return http.build();  // Build the HTTP security configuration
    }
}
