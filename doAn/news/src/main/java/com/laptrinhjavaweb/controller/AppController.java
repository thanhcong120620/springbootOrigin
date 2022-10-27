package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		String abc = "Nguyễn Thành Công";
		String abc1 = "Nguyễn Thành Công 4";
		String abc2 = "Nguyễn Thành Công 6";
		String abc3 = "Nguyễn Thành Công 8";
		List<String> list = new ArrayList<>();
		list.add(abc);
		list.add(abc1);
		list.add(abc2);
		list.add(abc3);
		model.addAttribute("list",list);
		return "index";
	}
	
	@GetMapping("/test")
	public String testAPI() {
		return "success";
	}
	
	
}
