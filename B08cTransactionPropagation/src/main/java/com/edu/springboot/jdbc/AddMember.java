package com.edu.springboot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class AddMember
{
	@Autowired
	ITicketService dao;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	@Transactional(propagation=Propagation.REQUIRED)
	public void memberInsert(TicketDTO ticketDTO, String errFlag)
	{
		try
		{
			transactionTemplate.execute(new TransactionCallbackWithoutResult()
			{
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status)
				{
					if(errFlag!=null && errFlag.equals("2")) {
						int money = Integer.parseInt("200원");
					}
					
					int result3 = dao.memberRegist(ticketDTO);
					if(result3==1)
						System.out.println("member 테이블 입력성공");
				}
			});
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("member 테이블 Rollback됨");
		}
	}
}
