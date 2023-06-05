package com.mysite.sr.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userNum;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private String name;
	
	@Column(unique = true)
	private String nickname;
	
	private LocalDate birthday;
	
	private LocalDateTime signupTime;
}
