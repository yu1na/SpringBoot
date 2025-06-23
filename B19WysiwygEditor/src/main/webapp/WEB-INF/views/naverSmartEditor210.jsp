<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>네이버 스마트 에디터 210</title>
      <script src="./SmartEditor2/js/service/HuskyEZCreator.js"></script>
      <script>
         var oEditors = [];
         window.onload = function(){
            nhn.husky.EZCreator.createInIFrame({
               oAppRef: oEditors,
               elPlaceHolder: "contents",
               sSkinURI: "./SmartEditor2/SmartEditor2Skin.html",
               fCreator: "createSEditor2"
            });
         }
         
         function validateForm(f){
            if(f.subject.value == ''){
               alert('제목을 입력하세요');
               f.subject.focus();
               return false;
            }
            
            oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
            
            let contents = document.getElementById("contents").value;
            if(contents == '<p>&nbsp;</p>'){
               alert('내용을 입력하세요');
               oEditors.getById["contents"].exec("FOCUS");
               return false;
            }
            /* console.log("contents", contents);
            return false; */
         }
      </script>
   </head>
   <body>
      <h2>네이버 스마트 에디터210</h2>
      <form method="post" onsubmit="return validateForm(this);">
      <span style="color:red;">${submit }</span>
      <table border="1" style="width:900px;">
      <colgroup>
         <col width="100px" />
         <col width="*" />
      </colgroup>
         <tr>
            <td>제목</td>
            <td><input type="text" name="subject" style="width:400px;" value="${paramDTO.subject }"/></td>
         </tr>
         <tr>
            <td>내용</td>
            <td>
               <!-- 에디터에 기본으로 삽입할 글(수정 모드)이 없다면 
               value 값을 지정하지 않으시면 됩니다. -->
               <textarea name="contents" id="contents" rows="10" cols="100">${paramDTO.contents }</textarea>
            </td>
         </tr>
         <tr>
            <td colspan="2">
               <input type="submit" value="전송하기" />
            </td>
         </tr>
      </table>
      </form>
   </body>
</html>