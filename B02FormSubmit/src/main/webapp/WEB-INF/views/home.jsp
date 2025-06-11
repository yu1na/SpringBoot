<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>Spring Boot 프로젝트</h2>
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
		
		<img src="/images/SpringBoot.png" alt="이미지표시" />
		
		<h2>정적 파일</h2>
		<ul>
			<li><a href="./index.html">index.html</a></li>
			<li><a href="./sub/sub.html">sub.html</a></li>
		</ul>
		
		<h2>View 매핑</h2>
		<ul>
			<li><a href="./index.do">index.do</a></li>
			<li><a href="./sub.do">sub.do</a></li>
		</ul>
		
		<h2>폼값전송</h2>
		<ul>
			<li><a href="form1.do?name=손오공&age=11">내장객체</a></li>
			<li><a href="form2.do?name=저팔계&age=22">어노테이션</a></li>
			<li><a href="form3.do?name=사오정&age=33">커맨드객체</a></li>
			<li><a href="form4/삼장법사/44">경로변수</a></li>
		</ul>
		
		<h2>퀴즈</h2>
		<ul>
			<li><a href="memberRegist.do">회원가입</a></li>
			<li><a href="memberLogin.do">로그인</a></li>
		</ul>
	</body>
</html>