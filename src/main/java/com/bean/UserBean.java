package com.bean;

import javax.validation.constraints.NotBlank;

public class UserBean {
	
	@NotBlank(message = "Email should not be blank")
	private String email;
	@NotBlank(message = "Password should not be blank")
	private String password;
	@NotBlank(message = "Firstname should not be blank")
	private String fname;
	private String profile;
	
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
