package com.example.demo.dto;

import javax.persistence.Column;

public class UserDto {
	private String username;
	
	private String password;
	
	private String name;
	
	private String lastname;
	
	private Boolean enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "username: ".concat(username).concat(", name: ").concat(name).concat(", lastname: ").concat(lastname).concat(", password: ").concat(password);
	}	
	
	
}
