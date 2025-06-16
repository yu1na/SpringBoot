package com.edu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.springboot.jdbc.ITicketService;
import com.edu.springboot.jdbc.PayDTO;
import com.edu.springboot.jdbc.TicketDTO;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class MainController
{   
   
   @Autowired
   ITicketService dao;
   
   @Autowired
   PlatformTransactionManager transactionManager;
   
   @Autowired
   TransactionDefinition definition;
   
   @RequestMapping("/")
   public String home()
   {
	   return "home";
   }
   
   @RequestMapping(value="/buyTicket.do", method=RequestMethod.GET)
   public String buy1()
   {
	   return "buy";
   }
   
   @RequestMapping(value="/buyTicket.do", method=RequestMethod.POST)
   public String buy2(TicketDTO ticketDTO, PayDTO payDTO,
		   HttpServletRequest req, Model model)
   {
	   String viewPath = "success";
	   TransactionStatus status = transactionManager.getTransaction(definition);
	   try
	{
		payDTO.setAmount(ticketDTO.getT_count() * 10000);
		int result1 = dao.payInsert(payDTO);
		if(result1==1) System.out.println("transaction_pay 입력성공");
		
		String errFlag = req.getParameter("err_flag");
		if(errFlag!=null) {
			int money = Integer.parseInt("100원");
		}
		
		int result2 = dao.ticketInsert(ticketDTO);
		if(result2==1) System.out.println("transaction_ticket 입력성공");
		
		model.addAttribute("ticketDTO", ticketDTO);
		model.addAttribute("payDTO", payDTO);
		
		transactionManager.commit(status);
	} catch (Exception e)
	{
		e.printStackTrace();
		viewPath = "error";
		transactionManager.rollback(status);
	}
	   return viewPath;
   }
}
