package com.onerivet.seciruty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.onerivet.passwordEncoder.Password;
@Configuration
@EnableWebSecurity
public class UserSercurity  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private Password password;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {


		 http.authorizeRequests().
		//.antMatchers("/","index").permitAll()
		 antMatchers("/users/**").hasAnyRole("User")
	       . anyRequest().authenticated()
	        .and()
	        .httpBasic()
    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        
	}
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails builder = User.builder()
				.username("khyati")
				.password(password.passwordcoder().encode("khyati@123"))
				.roles("User")
				.build();
				
		return new InMemoryUserDetailsManager(builder);
	}
	
	

}
