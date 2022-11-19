package com.stocksearch.stocksearch.controller1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	@RequestMapping("/admin")
	public String welcomeAdmin() {
		String text = "this is private page";
		return text;
	}
}
