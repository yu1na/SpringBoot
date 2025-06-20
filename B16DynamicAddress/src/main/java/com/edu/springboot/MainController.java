package com.edu.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.springboot.jdbc.AddressDTO;
import com.edu.springboot.jdbc.IAddressService;

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
	
	private static final String apiKey = ""
			
	@GetMapping("/01GeoLocation.do")
	public String geoFunc1(Model model)
	{
		model.addAttribute("apiKey", apiKey);
		return "01GeoLacation";
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
