package com.wildcodeschool.myProjectWithSecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

/*	    
 		// SINGLE-USER
	    http
	        .authorizeRequests()	 
	            .anyRequest().authenticated()
	            .and()
	        .formLogin()
	            .and()
	        .httpBasic();	    

	    
		// MULTI-USERS
	    http
           .authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
                 .and()
              .formLogin()
	             .and()
	          .httpBasic();
	    
	    http
           .authorizeRequests().antMatchers("/").hasRole("USER")	
				 .and()
              .formLogin()
                 .and()
              .httpBasic();
	
*/   
	    
	    
		// MULTI-USERS
	    http
           .authorizeRequests().antMatchers("/").permitAll()
                 .and()
              .formLogin()
	             .and()
	          .httpBasic();
	    
	    http
           .authorizeRequests().antMatchers("/avengers/assemble").hasRole("CHAMPION")	
				 .and()
              .formLogin()
                 .and()
              .httpBasic();
	    http
        .authorizeRequests().antMatchers("/secret-bases").hasRole("DIRECTOR")
                 .and()
              .formLogin()
	             .and()
	          .httpBasic();
	    
	    
	    
	}	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// THE PASSWORD IS NOT ENCODED ==> Will not work!!!!!!!!
	    //auth.inMemoryAuthentication().withUser("user").password("password").roles("");
		
		// ENCODE THE PASSWORD  
	    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    
        // SINGLE-USER		    
	    // auth.inMemoryAuthentication().withUser("user").password(encoder.encode("toto@com1")).roles("");
/*	    
		// MULTI-USERS	    
	 	auth.inMemoryAuthentication()
	 		.withUser("user")
	            .password(encoder.encode("toto@com1"))
	            .roles("USER")
	            .and()
	        .withUser("admin")
	            .password(encoder.encode("12345678"))
	            .roles("ADMIN");	    
*/
	 	
		// MULTI-USERS	    
	 	auth.inMemoryAuthentication()
	        .withUser("Steve")
	            .password(encoder.encode("motdepasse"))
	            .roles("CHAMPION")	    
	 			.and()
	 		.withUser("Nick")
	 			.password(encoder.encode("flerken"))
	 			.roles("DIRECTOR");	    
	 	
	 	
	 	
	}	

}