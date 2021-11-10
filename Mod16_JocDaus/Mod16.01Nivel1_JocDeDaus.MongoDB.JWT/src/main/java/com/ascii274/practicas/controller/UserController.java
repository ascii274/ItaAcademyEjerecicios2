package com.ascii274.practicas.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ascii274.practicas.models.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {
	/* *********************************************************
	 * http://localhost:8080/user?user=joel&password=mypassword
	 * *********************************************************
	 */
	@PostMapping("user")
	public User login(
			// aqui podemos validar usuario desde BBDD
			@RequestParam("user") String username, @RequestParam("password") String pwd) {
		String token = getJWTToken(username);		
		//User user = new User(username, token);
		User user = new User();
		user.setUser(username);
		user.setToken(token);
		return user;
	}
	// construye el token
	private String getJWTToken(String username) {
		String secretKey = "mypassword";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, 
						secretKey.getBytes()).compact();
		return "Bearer " + token;
	}

}
