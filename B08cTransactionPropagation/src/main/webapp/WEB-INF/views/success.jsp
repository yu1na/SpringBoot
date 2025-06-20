<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Success!!</title>
	</head>
	<body>
		<h2>티켓 구매 성공</h2>
		아이디 : ${ticketDTO.userid } <br/>
		구매수 : ${ticketDTO.t_count } <br/>
		결제금액: ${payDTO.amount } <br/>
		<a href="buyTicket.do">티켓 구매</a>
	</body>
</html>