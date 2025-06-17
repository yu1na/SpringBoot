package com.edu.springboot;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController
{   
   @RequestMapping("/")
   public String home()
   {
	   return "home";
   }
   
   @RequestMapping("/guest/index.do")
   public String welcome1()
   {
	   return "guest";
   }
   
   @RequestMapping("/member/index.do")
   public String welcome2()
   {
	   return "member";
   }
   
   @RequestMapping("/admin/index.do")
   public String welcome3()
   {
	   return "admin";
   }
   
   @RequestMapping("/myLogin.do")
   public String login1(Principal principal, Model model)
   {
	   try
	{
		String user_id = principal.getName();
		model.addAttribute("user_id", user_id);
	} catch (Exception e)
	{
		System.out.println("로그인 전입니다");
	}
	   return "auth/login";
   }
   
   @RequestMapping("/myError.do")
   public String login2()
   {
	   return "auth/error";
   }
   
   @RequestMapping("/denied.do")
   public String login3()
   {
	   return "auth/denied";
   }
}
