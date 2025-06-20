<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>home 화면</title>
		<!-- 정적 리소스인 js와 css파일이 링크 -->
		<script src="./js/commons.js"></script>
		<link rel="stylesheet" href="./css/main.css" />
	</head>
	<body>
		<h2>스프링 부트 프로젝트-시큐리티</h2>
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
		
		<script>
			window.onload = function()
			{
				myConsole("시큐리티");
			}
		</script>
		
		<h2>Spring Security 기본</h2>
		<ul>
			<li><a href="/guest/index.do">Guest</a></li>
			<br/>
			<li><a href="/member/index.do">Member</a></li>
			<br/>
			<li><a href="/admin/index.do">Admin</a></li>
		</ul>
		
		<div class="spring" onclick="myAlert();">
			여기를 클릭하세요.
		</div>
	</body>
</html>