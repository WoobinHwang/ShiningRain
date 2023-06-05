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
		return "SignupPage";
	}
	
	@PostMapping("/signup")
	public String Signup(UserList user) {
		userService.create(user.getUsername(), user.getPassword()
				, user.getName(), user.getNickname(), user.getBirthday());
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String LoginPage() {
		return "LoginPage";
	}

}
