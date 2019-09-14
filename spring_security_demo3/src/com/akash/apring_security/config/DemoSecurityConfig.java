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
	
		auth.inMemoryAuthentication().withUser(users.username("akash").password("123").roles("emp"))
		.withUser(users.username("priyanshu").password("123").roles("mgr","emp"))
		.withUser(users.username("anu").password("123").roles("admin","emp"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		
		http.authorizeRequests().antMatchers("/")
		.hasRole("emp")
		.antMatchers("/leader/**")
		.hasRole("mgr")
		.antMatchers("/sys/**")
		.hasRole("admin").and()
		.formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/accessDenied");
	}
}
