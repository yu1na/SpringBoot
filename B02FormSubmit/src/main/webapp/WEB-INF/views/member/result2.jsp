<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 결과</title>
	</head>
	<body>
		<h2>퀴즈] 로그린 폼에서 전송된 값</h2>
		<ul>
			<li>아이디 : ${quizVO.id }</li>
			<li>비밀번호 : ${quizVO.pass1 }</li>
		</ul>
	</body>
</html>