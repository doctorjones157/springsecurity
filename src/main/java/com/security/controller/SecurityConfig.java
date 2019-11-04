package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	private AuthenticationProvider authenticationProvider;
	
	  @Autowired
	  @Qualifier("daoAuthenticationProvider")
	  public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	  }
	  @Bean
	  public DaoAuthenticationProvider daoAuthenticationProvider(CustomUserDetailService userDetailsService) {
		  DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		  provider.setUserDetailsService(userDetailsService);
		  return provider;
	  }
	  @Autowired
	  public void configAuthManager(AuthenticationManagerBuilder builder) {
		  builder.authenticationProvider(authenticationProvider);
	  }
	  

	@Override
	  protected void configure(HttpSecurity http) throws Exception {

        http.csrf().ignoringAntMatchers("/h2-console").disable()
                .authorizeRequests().antMatchers("/**/favicon.ico") .permitAll()
                .and().authorizeRequests().antMatchers("/product/**").permitAll()
                .and().authorizeRequests().antMatchers("/webjars/**").permitAll()
                .and().authorizeRequests().antMatchers("/static/css").permitAll()
                .and().authorizeRequests().antMatchers("/js").permitAll()
                .and().formLogin().loginPage("/login").permitAll()
                .and().authorizeRequests().antMatchers("/api/**").authenticated()
                .and().authorizeRequests().antMatchers("/user/**").hasAnyAuthority("ADMIN")
                .and().exceptionHandling().accessDeniedPage("/access_denied");
    
	}
		 
	}
