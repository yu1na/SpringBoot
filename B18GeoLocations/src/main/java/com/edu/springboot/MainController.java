package com.edu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edu.springboot.mybatis.ISearchRadius;

@Controller
public class MainController
{
	
	@Autowired
	ISearchRadius dao;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	private static final String apiKey = "AIzaSyAkXFR_p0Jd1kb98j0OhVIhYYv18ceiIYo";
			
	@GetMapping("/01GeoLocation.do")
	public String geoFunc1(Model model)
	{
		model.addAttribute("apiKey", apiKey);
		return "01GeoLocation";
	}
	
	@GetMapping("/02GoogleMap.do")
	public String geoFunc2(Model model)
	{
		model.addAttribute("apiKey", apiKey);
		return "02GoogleMap";
	}
	
	@GetMapping("/03MyLocation.do")
	public String geoFunc3(Model model)
	{
		model.addAttribute("apiKey", apiKey);
		return "03MyLocation";
	}
}
