package com.mysite.sr.Board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

	@GetMapping("write")
	public String writePage(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("test", "tetest");
		
		return "BoardWritePage";
	}
	
	
}
