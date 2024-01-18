package com.pring.secuirity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("milan")
									.password("milan@123")
									.roles("ADMIN");
		
		auth.inMemoryAuthentication().withUser("bapun")
		.password("bapun@123")
		.roles("USER");
		
	}
	
	
	//security for All api
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable(); http.authorizeRequests().anyRequest()
	 * .fullyAuthenticated() .and().httpBasic(); }
	 */
	
	
//Security based on URL
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable(); http.authorizeRequests()
	 * .antMatchers("/rest/auth/**").fullyAuthenticated() .and().httpBasic(); }
	 */
	
//Security based on role
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/rest/auth/**")
			.hasAnyRole("ADMIN").anyRequest()
			.fullyAuthenticated().and().httpBasic();
	}
	
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
