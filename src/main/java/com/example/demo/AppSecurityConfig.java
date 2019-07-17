package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	private UserDetailsService UserDetailsService;
	
	@Bean 
	public AuthenticationProvider AuthProv() 
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(UserDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
		    .csrf().disable()
		    .authorizeRequests().antMatchers("/login").permitAll()
		    .anyRequest().authenticated()
		    .and()
		    .formLogin()
		    .loginPage("/login").permitAll()
		    .and()
		    .logout().invalidateHttpSession(true)
		    .clearAuthentication(true)
		    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		    .logoutSuccessUrl("/logout-success").permitAll();
		    
		    
	}
	
	
	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() 
//	{
//		List<UserDetails> users =new ArrayList<>();
//		
//		users.add(User.withDefaultPasswordEncoder().username("amin").password("amin123").roles("USER").build());
//		
//		return new InMemoryUserDetailsManager(users);
//	}

	
}
