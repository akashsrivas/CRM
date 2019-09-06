package com.akash.apring_security.config;

import org.apache.catalina.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//super.configure(auth);
		UserBuilder users=org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder();
	
		auth.inMemoryAuthentication().withUser(users.username("abc").password("123").roles("xyz"))
		.withUser(users.username("abc1").password("1231").roles("xyz1"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		
		http.authorizeRequests().anyRequest().authenticated().and()
		.formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and().logout().permitAll();
	}
}
