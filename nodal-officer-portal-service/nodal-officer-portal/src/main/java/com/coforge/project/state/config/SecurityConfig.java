package com.coforge.project.state.config;


/**
*Author:Koppula.Reddy
*date:Dec 13, 2024
*time:8:11:10 PM
*project:nodal-officer-portal

**/
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

	@Configuration
	public class SecurityConfig {

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(authorize -> authorize
	                .anyRequest().permitAll() // Permit all requests
	            )
	            .csrf().disable(); // Disable CSRF for simplicity (not recommended in production)
	        
	        return http.build();
	    }
	}


