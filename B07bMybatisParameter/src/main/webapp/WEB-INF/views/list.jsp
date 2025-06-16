<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>리스트</title>
   </head>
   <script>
   let deletePost = function(user_id){
      let frm = document.frm;
      if(confirm('정말 삭제할까요?')){
         frm.id.value = user_id;
         frm.action = "delete.do";
         frm.method = "post";
         frm.submit();
      }
   }
   </script>
   <!-- jQuery의 CDN 추가 -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
   <body>
   <script>
   function validateForm(fm){
		let sFieldCnt = 0;
		for(let i=0; i<fm.searchField.length; i++){
			if(fm.searchField[i].checked==true)
				sFieldCnt++;
		}
		if(sFieldCnt==0){
			alert("한 개 이상의 항목을 체크 해주세요.")
			return false;
		}
	}
   </script>
      <form onsubmit="return validateForm(this)";>
         <table>
            <tr>
               <td>
                  <input type="checkbox" name="searchField" value="id" />아이디
                  <input type="checkbox" name="searchField" value="name" />이름
                  <input type="checkbox" name="searchField" value="pass" />패스워드
                  <input type="text" name="searchKeyword" />
                  <input type="submit" value="검색" />
               </td>
            </tr>   
         </table>
      </form>
   
      <form name="frm"><!-- 자바스크립트를 이용한 삭제 -->
         <input type="hidden" name="id">
      </form>
      <h2>회원 리스트</h2>
      <table border="1">
         <tr>
            <th>아이디</th>
            <th>패스워드</th>
            <th>이름</th>
            <th>가입일</th>
            <th></th>
         </tr>
         <!-- <tr>태그에 중복되지 않는 아이디를 부여한다. -->
         <c:forEach items="#{memberList }" var="row" varStatus="loop">
         <tr id="member_${row.id }">
            <td>${row.id }</td>
            <td>${row.pass }</td>
            <td>${row.name }</td>
            <td>${row.regidate }</td>
            <td>
               <a href="edit.do?id=${row.id }">수정</a>
               <%-- <a href="delete.do?id=${row.id }">삭제</a> --%>
                <a href="javascript:;" onclick="deletePost('${row.id }');">삭제</a>
               <%-- <a href="javascript:ajaxDelete('${row.id }');">삭제</a> --%>
            </td>
         </tr>
         </c:forEach>
      </table>
      <a href="regist.do">회원등록</a>
   </body>
</html>