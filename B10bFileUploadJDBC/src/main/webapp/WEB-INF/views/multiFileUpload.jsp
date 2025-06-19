<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>멀티 파일 업로드</title>
		<script>
		    function validateForm(form) { 
		        if (form.title.value == "") {
		            alert("제목을 입력하세요.");
		            form.title.focus();
		            return false;
		        }
		        if (form.ofile.value == "") {
		            alert("첨부파일은 필수 입력입니다.");
		            return false;
		        }
		    }
		</script>
	</head>
	<body>
		<h2>멀티파일업로드</h2>
	    <form name="fileForm" method="post" enctype="multipart/form-data"
	          action="multiUploadProcess.do" onsubmit="return validateForm(this);">        
	        제목 : <input type="text" name="title" /><br /> 
	        카테고리(선택사항) : 
	            <input type="checkbox" name="cate" value="사진" checked />사진 
	            <input type="checkbox" name="cate" value="과제" />과제 
	            <input type="checkbox" name="cate" value="워드" />워드 
	            <input type="checkbox" name="cate" value="음원" />음원 <br />
	        <!--  
	        파일 입력상자에 multiple 속성을 추가하면 2개 이상의 파일을 선택할 수 있다. 
	        드레그 혹은 Ctrl, Shift를 이용하면된다. 
	        -->    
	        첨부파일 : <input type="file" name="ofile" multiple /> <br />
	        <input type="submit" value="전송하기" />
	    </form>
	</body>
</html>