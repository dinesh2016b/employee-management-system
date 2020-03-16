/**
 * 
 */
package com.online.ems.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Autowired private MyUserDetailsService myUserDetailsService;
	 */
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	} 
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	
		/*
		 * httpSecurity.authorizeRequests() .antMatchers("/employees").hasRole("USER")
		 * .antMatchers("/departments").hasRole("USER")
		 * .antMatchers("/h2-console/**").permitAll() .antMatchers("/").permitAll()
		 * .anyRequest() .authenticated() .and() .httpBasic();
		 */
		//httpSecurity.headers().frameOptions().disable();

		httpSecurity.cors().and().csrf().disable();

		httpSecurity.authorizeRequests()
		.antMatchers("/employees").hasAnyRole("USER", "ADMIN", "ANONYMOUS")
		.antMatchers("/departments").hasAnyRole("USER", "ADMIN", "ANONYMOUS")
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers("/").permitAll()
		.anyRequest()
        .authenticated()
        .and()
        .httpBasic();
		
		httpSecurity.headers().frameOptions().disable();

	}
}
