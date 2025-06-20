import React from "react";
import { useNavigate } from "react-router-dom";


function MyWrite(props) {
    console.log(props);
    const navigate = useNavigate();
    return (
        <div>
        <h2>Spring 게시판[작성]</h2>
        <form onSubmit={(event)=>{
            event.preventDefault();
            let id = event.target.id.value;
            let title = event.target.title.value;
            let content = event.target.content.value;

            const params = new URLSearchParams();
            params.set('id', id);
            params.set('title', title);
            params.set('content', content);

        
        const data = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: params
        };
          fetch('http://localhost:8586/restBoardWrite.do', data)
              .then((result)=>{
                  return result.json();
              })
              .then((json)=>{
                  console.log(json);
                  if(json.result===1){
                      console.log("글쓰기 성공");
                  }
              });
          navigate("/list");
        }}>
        
        <table border='1'>
              <tbody>
              <tr>
                  <th>작성자</th>
                  <td><input type="text" name="id" value="musthave" /></td>
              </tr>

              <tr>
                  <th>제목</th>
                  <td><input type="text" name="title" /></td>
              </tr>

              <tr>
                  <th>내용</th>
                  <td><textarea name="content" cols='22' rows='3'></textarea></td>
              </tr>
              </tbody>
        </table>
        <input type="submit" value="Submit" />
        </form>
        </div>
    );
}

export default MyWrite;