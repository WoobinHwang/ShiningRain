package com.mysite.sr.user;

import lombok.Getter;

@Getter
public enum UserRole {
	admin("suho"),
	user("ROLE_USER");
	
	UserRole(String value){
		this.value = value;
	}
	
	private String value;
	
}
