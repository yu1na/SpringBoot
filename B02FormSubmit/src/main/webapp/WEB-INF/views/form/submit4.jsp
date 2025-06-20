<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>submit4</title>
	</head>
	<body>
		<h2>폼값 전송4 : @PathVariable</h2>
		<p>
			이름 : ${name } <br/>
			나일 : ${age }
		</p>
		<!--  
		요청명이 'form4/삼장법사/44'와 같으므로 루트경로 하위 2Depth로 인식한다.
		따라서 이미지의 경로는 아래와 같이 ../을 두번 추가해야한다. 
		-->
		<img src="../../images/SpringBoot.png" />
	</body>
</html>