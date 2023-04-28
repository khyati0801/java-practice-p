package com.onerivet.security;

import org.hibernate.annotations.Comment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class UserSercurity {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {

		http
		.cors().and()
		.csrf().disable()
		.authorizeHttpRequests((authorize)->authorize.requestMatchers("/api/employee/login","/api/employee/authenticate").permitAll()
		// .requestMatchers("/api/employee/**","/api/employee/authenticate").permitAll()
		.anyRequest().authenticated())
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();

	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(UserDetailsService());
		authenticationProvider.setPasswordEncoder(PasswordEncoder());
		
		return authenticationProvider;
		
		
	}
	private PasswordEncoder PasswordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}

	private UserDetailsService UserDetailsService() {
		// TODO Auto-generated method stub
		return UserDetailsService() ;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
		
	}

}
