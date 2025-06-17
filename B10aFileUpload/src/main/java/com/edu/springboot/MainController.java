package com.edu.springboot;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController
{   
   @RequestMapping("/")
   public String home()
   {
	   return "home";
   }
   
   @GetMapping("/fileUpload.do")
   public String fileUpload() 
   {
	   return "fileUpload";
   }
}
