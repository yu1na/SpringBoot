package com.edu.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.springboot.jdbc.IMemberService;
import com.edu.springboot.jdbc.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController
{   
   @Autowired
   IMemberService dao;
   
   @RequestMapping("/")
   public String home()
   {
      return "home";
   }
   
   //회원목록
   @RequestMapping("/list.do")
   public String member2(Model model, MemberDTO memberDTO)
   {
	   System.out.println(memberDTO.getSearchField());
	   System.out.println(memberDTO.getSearchKeyword());
	   
		/* model.addAttribute("memberList", dao.select()); */
      model.addAttribute("memberList", dao.select(memberDTO));
      return "list";
   }
   
   //회원정보추가 
//   @RequestMapping(value = "/regist.do", method = RequestMethod.GET)
   @GetMapping("/regist.do")
   public String member1()
   {
      return "regist";
   }
   
//   @RequestMapping(value = "/regist.do", method = RequestMethod.POST)
   @PostMapping("/regist.do")
   public String member6(HttpServletRequest req)
   {
      String id = req.getParameter("id");
      String pass = req.getParameter("pass");
      String name = req.getParameter("name");
      
      int result = dao.insert(id, pass, name);
      if(result==1) System.out.println("입력되었습니다.");
      return "redirect:list.do";
   }
   
//   @RequestMapping(value = "/edit.do", method = RequestMethod.GET)
   @GetMapping("/edit.do")
   public String member3(HttpServletRequest req, MemberDTO memberDTO,
         Model model)
   {
      memberDTO = dao.selectOne(req.getParameter("id"));
      model.addAttribute("dto", memberDTO);
      return "edit";
   }
   
   //회원정보수정2 : 수정처리 
//   @RequestMapping(value = "edit.do", method = RequestMethod.POST)
   @PostMapping("edit.do")
   public String member7(HttpServletRequest req)
   {
      String id = req.getParameter("id");
      String pass = req.getParameter("pass");
      String name = req.getParameter("name");
      
      Map<String, String> paramMap = new HashMap<String, String>();
      paramMap.put("m_id", id);
      paramMap.put("m_pass", pass);
      paramMap.put("m_name", name);
      
      int result = dao.update(paramMap);
      if (result==1) System.out.println(" 수정되었습니다.");
      return "redirect:list.do";   
   }
   
   //회원삭제
   @RequestMapping("/delete.do")
   public String member4(HttpServletRequest req) {
      String id = req.getParameter("id");
      int result = dao.delete(id);
      if(result==1) System.out.println("삭제되었습니다.");
      return "redirect:list.do";
   }
   
//   // 비동기 방식으로 회원 삭제
//      @RequestMapping("/delete.do")
//      public Map<String, String> member4(MemberDTO memberDTO) {
//         
//         int result = dao.delete(memberDTO);
//         Map<String, String> map = new HashMap<>();
//         if (result==1)
//         {
//            System.out.println("삭제되었습니다.");
//            map.put("result", "success");
//         } else
//         {
//            System.out.println("삭제실패");
//            map.put("result", "fail");
//         }
//         return map;
//      }
   
   
   
   
}
