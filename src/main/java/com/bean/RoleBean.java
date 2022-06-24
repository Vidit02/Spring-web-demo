package com.bean;

import javax.validation.constraints.NotBlank;

public class RoleBean {
	int roleid;
	@NotBlank(message = "Please enter the input")
	String roleName;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
