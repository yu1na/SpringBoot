<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>address</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<script>
		$(function(){
			$('#sido').change(function(){
				//'시도'를 선택하면 '구군'을 얻기위해 아래와 같이 요청한다. 
				$.ajax({
					//요청명
					url : "./getGugun.do",
					//요청방식
					type : "get",
					contentType : "text/html;charset:utf-8;",
					//파라미터(선택한 시/도를 전달)
					data : {
						sido : $('#sido option:selected').val()
					},
					//콜백데이터의 형식 
					dataType : "json",
					success : function(d){
						/*
						콜백데이터는 {result : [{객체}, {객체}, ...]} 이와같은
						포맷이므로 result 키값에 저장된 배열의 크기만큼 반복해서 
						파싱할 수 있다. 
						*/
						console.log(d);
						var optionStr = "";
						optionStr += "<option value=''>";
						optionStr += "-구군을 선택하세요-";
						optionStr += "</option>";
						/* each() 함수를 통해 배열의 크기만큼 반복해서 <option>
						태그를 추가한다. */
						$.each(d.result, function(index, data){
							optionStr += '<option value="'+data.gugun+'">';
							optionStr += data.gugun;
							optionStr += '</option>';
						});
						/* 두번째 <select>태그에 삽입한다. */
						$('#gugun').html(optionStr);
					},
					error : function(e){
						alert("오류발생 :" + e.status+":"+e.statusText);
					}
				});	
			});
		});
		</script>
	</head>
	<body>
	<div class="container">
		<div class="row">
			<h2>우편번호DB를 이용한 시도/구군 동적셀렉느 구현</h2>
		</div>
		<form id="zipFrm">
		<div class="row">
			<div class="col-4">
			시/도 : 
			<select id="sido" class="form-control">
				<option value="">-시/도를 선택하세요-</option>
				<c:forEach items="${sidoLists }" var="sidoRow">
					<option value="${sidoRow.sido }">${sidoRow.sido }</option>
				</c:forEach>
			</select>
			</div>
			<div class="col-8">
			구/군 : 
			<select id="gugun" class="form-control">
				<option value="">-구군을 선택하세요-</option>
			</select>
			</div>
		</div>
		</form>
	</div>
	</body>
</html>