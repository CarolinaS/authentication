package com.tcs.authentication.config ;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{

    auth.inMemoryAuthentication()
    .withUser("caro").password("{noop}fisi").roles("USER").and()
    .withUser("back").password("{noop}tata").roles("ADMIN");
    
}
@Override
public void configure(HttpSecurity httpSecurity) throws Exception{

      httpSecurity
      .authorizeRequests()
      //.antMatchers()
      .anyRequest()
      .fullyAuthenticated()
      //.permitAll()
      .and().httpBasic();

      httpSecurity.csrf().disable();




}



}