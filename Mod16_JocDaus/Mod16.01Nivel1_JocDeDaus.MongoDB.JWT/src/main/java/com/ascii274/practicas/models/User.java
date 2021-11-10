package com.ascii274.practicas.models;

public class User {
	private String user;
	private String pwd;
	private String token;
	
	public User() {
	
	}
	public User(String user, String token ) {
		this.user = user;
		this.token = token;

	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String password) {
		this.pwd = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
