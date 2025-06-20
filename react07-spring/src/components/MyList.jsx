import React, {useState, useEffect} from "react";
import { Link } from 'react-router-dom';

function MyList(props) {
  var [myJSON, setmyJSON] = useState([]);
  console.log(props)

  useEffect(function () {
    fetch("http://localhost:8586/restBoardList.do?pageNum=1")
    .then((result)=>{
        // console.error("결과1");
        // console.log(result);
        return result.json();
    })
    .then((json)=>{
        console.error("결과");
        console.log(json);
        setmyJSON(json);
    });
    return ()=>{
    console.log('#Life', 'useEffect실행==>컴포넌트 언마운트');
    }
  }, []);
  let trTag = [];
  for(let i=0 ; i<myJSON.length ; i++) {
      let data = myJSON[i];
      // console.log(data)
      trTag.push(
      <tr key={data.num}>
          <td>{data.num}</td>
          <td><Link to={'/view/'+data.num}>{data.title}</Link></td>
          <td>{data.id}</td>
          <td>{data.postdate}</td>
          <td>{data.visitcount}</td>
      </tr>  
      );
  }
  return (
    <div>
    <h2>Spring 게시판[목록]</h2>
    <table border='1'>
      <thead>
      <tr>
          <th>num</th>
          <th>title</th>
          <th>id</th>
          <th>postdate</th>
          <th>visitcount</th>
      </tr>
      </thead>
      <tbody>{trTag}</tbody>
    </table>
    <Link to="/write">작성</Link>
    </div>
  );
}

export default MyList;