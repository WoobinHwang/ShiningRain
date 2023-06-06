package com.mysite.sr.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	//회원가입
	public UserList create(String username, String password
			, String name, String nickname, LocalDate birthday) {
		
		UserList user = new UserList();
		
		// 아이디는 대문자로 변환
		// 비밀번호는 인코딩 작업
		user.setUsername(username.toUpperCase());
		user.setPassword(passwordEncoder.encode(password));
		user.setName(name);
		user.setNickname(nickname);
		user.setBirthday(birthday);
		user.setSignupTime(LocalDateTime.now());
		
		this.userRepository.save(user);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 로그인
		// 아이디는 대문자로 변환
		username = username.toUpperCase();
		
		Optional<UserList> _user = this.userRepository.findByusername(username);
		
		if (_user.isEmpty()) {
			throw new UsernameNotFoundException(username + ": 로그인 실패");
		}
		
		UserList user = _user.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        if ("suho".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.admin.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.user.getValue()));
        }
        
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
}
