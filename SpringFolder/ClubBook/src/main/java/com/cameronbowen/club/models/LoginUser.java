package com.cameronbowen.club.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginUser {

	@NotEmpty(message="email must be non-empty!")
	@Email(message="Must be a valid email!")
	private String email;
	
	@NotEmpty(message="password must be non-empty!")
	private String password;
	
	public LoginUser() {
	}

	public LoginUser(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
