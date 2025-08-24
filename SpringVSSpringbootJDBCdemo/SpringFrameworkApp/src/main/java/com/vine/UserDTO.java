package com.vine;

public class UserDTO {
	String name;
	String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserDTO(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

}
