<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>FileUpload</title>
	</head>
	<body>
		<h2>파일업로드 성공</h2>
		업로드 한 파일 명 : ${originalFileName } <br>
		저장 된 파일 명: ${savedFileName } <br>
		<img src="./uploads/${savedFileName }"> <br>
		제목 : ${title } <br>
		카테고리 :
		<c:forEach items="${cate }" var="row" varStatus="status">
			${row }
			<c:if test="${status.last eq false }">,</c:if>
		</c:forEach>
	</body>
</html>