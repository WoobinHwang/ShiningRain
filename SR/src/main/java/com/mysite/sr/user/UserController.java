package com.mysite.sr.user;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/signup")
	public String SignupPage() {
		// TODO Auto-generated method stub
		return "SignupPage";
	}
	
	@PostMapping("/signup")
	public String Signup(UserList user) {
		// TODO Auto-generated method stub
		System.out.println("cont start");
		userService.create(user.getUsername(), user.getPassword()
				, user.getName(), user.getNickname(), user.getBirthday());
		System.out.println("cont end");
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String LoginPage() {
		// TODO Auto-generated method stub
		return "LoginPage";
	}

}
