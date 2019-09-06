package com.akash.apring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHmoe()
	{
		return "home";
	}
	@GetMapping("/leader")
	public String leader()
	{
		return "leader";
	}

}
