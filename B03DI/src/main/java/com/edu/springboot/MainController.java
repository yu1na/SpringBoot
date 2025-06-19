package com.edu.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController
{
	//home 경로 매핑 
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	
}
