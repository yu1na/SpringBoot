package com.edu.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController
{
	@RequestMapping("/")
	public String home() 
	{
		return "home";
	}
	
	@RequestMapping("/index.do")
	public String index() 
	{
		return "index";
	}
	
	@RequestMapping("/sub.do")
	public String sub() 
	{
		return "sub/sub";
	}
	
	@RequestMapping("/form1.do")
	public String form1(HttpServletRequest httpServletRequest, Model model)
	{
		String name = httpServletRequest.getParameter("name");
		String age = httpServletRequest.getParameter("age");
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "form/submit1";
	}
	
	@RequestMapping("/form2.do")
	public String form2(@RequestParam("name") String name, 
			@RequestParam("age") String age, Model model)
	{
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "form/submit2";
	}
	
	@RequestMapping("/form3.do")
	public String form3(PersonDTO personDTO) 
	{
		return "form/submit3";
	}
	
	@RequestMapping("/form4/{name1}/{age1}")
	public String form4(@PathVariable("name1") String name2, 
			@PathVariable("age1") String age2, Model model)
	{
		model.addAttribute("name", name2);
		model.addAttribute("age", age2);
		
		return "form/submit4";
	}
	
	@RequestMapping("/memberRegist.do")
	public String memberRegist()
	{
		return "member/regist";
	}
	
	@RequestMapping("registProcess.do")
	public String registProcess(QuizVO quizVO)
	{
		return "member/result";
	}
}
