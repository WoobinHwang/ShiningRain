package com.mysite.sr.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserList create(String username, String password
			, String name, String nickname, LocalDate birthday) {
		System.out.println("aaa");
		
		UserList user = new UserList();
		
		// 아이디는 대문자로 변환
		// 비밀번호는 인코딩 작업
		user.setUsername(username.toUpperCase());
		user.setPassword(passwordEncoder.encode(password));
		user.setName(name);
		user.setNickname(nickname);
		user.setBirthday(birthday);
		user.setSignupTime(LocalDateTime.now());
		System.out.println("bbb");
		
		this.userRepository.save(user);
		System.out.println("ccc");
		// TODO Auto-generated method stub
		return user;
	}
}
