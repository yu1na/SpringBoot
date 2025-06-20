package com.edu.springboot.lombok;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DTOController
{
	@GetMapping("/dto.do")
	public String home(MemberDTO memberDTO, Model model)
	{
		memberDTO.setId("hrdnet");
		memberDTO.setName("직업훈련포탈");
		memberDTO.setPass("1234");
		memberDTO.setRegidate("2025-06-11");
		
		model.addAttribute("dto", memberDTO);
		
		return "dto";
	}
}
