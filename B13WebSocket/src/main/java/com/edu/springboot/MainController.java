package com.edu.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController
{
	@GetMapping("/notview")
	@ResponseBody
	public String main()
	{
		return "View 없이 컨트롤러에서 즉시 출력";
	}
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/chatMain.do")
	public String chatMain()
	{
		return "chatMain";
	}
	
	@GetMapping("/chatWindow.do")
	public String chatWindow()
	{
		return "chatWindow";
	}
}
