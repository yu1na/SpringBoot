package com.edu.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.springboot.jdbc.AddressDTO;
import com.edu.springboot.jdbc.IAddressService;


@Controller
public class MainController
{
	@Autowired
	IAddressService dao;
	
	@GetMapping("/notview")
	@ResponseBody
	public String main()
	{
		return "View 없이 컨트롤러에서 즉시 출력";
	}
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/dynamicAddress.do")
	public String address1(Model model) {
		model.addAttribute("sidoLists", dao.selectsido());
		return "address";
	}
	
	@RequestMapping("/getGugun.do")
	@ResponseBody
	public Map<String, Object> address2(AddressDTO addressDTO){
		List<AddressDTO> guguLists = dao.selectGugun(addressDTO);
		Map<String, Object> maps = new HashMap<>();
		maps.put("result", guguLists);
		return maps;
	}
}