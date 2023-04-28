package com.onerivet.seciruty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.onerivet.passwordEncoder.Password;
import com.onerivet.service.impl.UserDetailsServiceImpl;
@Configuration
@EnableWebSecurity
public class UserSercurity  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private Password password;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {


		 http.authorizeRequests().
		//.antMatchers("/","index").permitAll()
		 antMatchers("/users/**").permitAll()
	       . anyRequest().authenticated()
	        .and()
	        .httpBasic()
    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        
	}
	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		UserDetails builder = User.builder()
//				.username("khyati")
//				.password(password.passwordcoder().encode("khyati@123"))
//				.roles("User")
//				.build();
//				
//		return new InMemoryUserDetailsManager(builder);
//	}
	
	
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider xyz=new DaoAuthenticationProvider();
		xyz.setUserDetailsService(userDetailsServiceImpl);
		xyz.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return xyz;
	}
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	

}
