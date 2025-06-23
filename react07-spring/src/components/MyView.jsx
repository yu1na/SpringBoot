import React, { useEffect, useState } from "react";
import {Link, useParams } from "react-router-dom";


function MyView(props) {
    console.log(props)
    var params = useParams();
    console.log("파라미터", params.num);
    var [boardRow, setBoardRow] = useState({});

    useEffect(function () {
        fetch("http://localhost:8586/restBoardView.do?num="+params.num)
        .then((result)=>{
           return result.json();
        })
        .then((json)=>{
            //console.error("결과");
            console.log(json);
            setBoardRow(json);
        });
        return ()=>{
          console.log('#Life','useEffect실행==>컴포넌트 언마운트');
        }
    }, []);
    return (
        <div>
        <h2>Spring 게시판[조회]</h2>
        <table border='1'>
              <tbody>
              <tr>
                <th>작성자</th>
                <td>{boardRow.id}</td>  
              </tr>

              <tr>
                  <th>제목</th>
                  <td>{boardRow.title}</td>  
              </tr> 
              
              <tr>
                  <th>작성일</th>
                  <td>{boardRow.postdate}</td>  
              </tr>

              <tr>
                  <th>내용</th>
                  <td>{boardRow.content}</td>  
              </tr> 
              </tbody>
        </table> 
        <Link to="/list">목록</Link>
        </div>
    );
}

export default MyView;