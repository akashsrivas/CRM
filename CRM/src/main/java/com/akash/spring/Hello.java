package com.akash.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	@RequestMapping("/add")
	public String add()
	{
		System.out.println("i am here");
		return "index";
	}
}
