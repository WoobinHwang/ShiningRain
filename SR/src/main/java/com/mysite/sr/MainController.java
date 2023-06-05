package com.mysite.sr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	@GetMapping("/")
	public String Main() {
		return "MainPage";
	}
	
	@GetMapping("main")
	public String MainPage() {
		return "MainPage";
	}
}
