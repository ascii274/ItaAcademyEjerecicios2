package com.ascii274.practicas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ascii274.practicas.security.JWTAuthorizationFilter;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//jwt
	@EnableWebSecurity
	@Configuration	
	public class WebSecurtiyConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure (HttpSecurity http) throws Exception{
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), 
						UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST,"/user").permitAll()
				.antMatchers(HttpMethod.GET,"/jocdedaus").permitAll()
				//.antMatchers(HttpMethod.GET,"/jocdedaus/player/ranking/").permitAll()
				//.antMatchers(HttpMethod.GET,"/jocdedaus/id/games").permitAll()
				.anyRequest().authenticated();
		}
	}

	
	

}
