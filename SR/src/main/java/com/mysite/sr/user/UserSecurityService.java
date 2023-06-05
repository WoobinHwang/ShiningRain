package com.mysite.sr.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSecurityService 
//	implements UserDetailsService
		{

//	private final UserRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// 로그인
//		Optional<UserList> _user = this.userRepository.findByusername(username);
//		
//		if (_user.isEmpty()) {
//			throw new UsernameNotFoundException(username + ": 로그인 실패");
//		}
//		
//		UserList user = _user.get();
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        
//        if ("suho".equals(username)) {
//            authorities.add(new SimpleGrantedAuthority(UserRole.admin.getValue()));
//        } else {
//            authorities.add(new SimpleGrantedAuthority(UserRole.user.getValue()));
//        }
//        
//		
//		return new User(user.getUsername(), user.getPassword(), authorities);
//	}
	
}
