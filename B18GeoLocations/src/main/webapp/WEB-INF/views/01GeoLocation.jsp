<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>01GeoLocation.jsp</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<script type="text/javascript">
		/*
		Geolocation : 위치정보 서비스로써 브라우저가 현재 위도와 경도를 JS코드에게
			공급하는 서비스 
			
			getCurrentPosition() : 현재 위치 얻기
			사용법 : getCurrentPosition(
						현재위치가 파악되었을때 호출되는 콜백함수,
						위치파악 중 오류발생시 호출되는 콜백함수,
						옵션(위치파악을 위한 최대 허용시간, 대기시간, 정확도)
				   );
		 
		*/
		var span;
		window.onload = function(){
			//결과를 출력할 DOM 객체
			span = document.getElementById("result");
			//현재 웹브라우저가 geolocation을 지원하는지 확인
			if(navigator.geolocation){
				span.innerHTML = "Geolocation API를 지원합니다.";
				/*
				현재위치를 얻기위한 옵션
				enableHighAccuracy : 정확도를 결정하는 Boolean값 
				timeout : 위치값을 장치로 받을때까지의 대기시간
				maximumAge : 캐시된 위치값을 반환받을 수 있는 대기시간. 
					0으로 지정하면 캐시를 사용하지않고 항상 현재값을 가져옴.
				*/
				var options = {
					enableHighAccuracy:true,
					timeout:5000,
					maximumAge:3000
				};
				//현재위치얻기 : 2개의 콜백함수와 옵션을 매개변수로 설정 
				navigator.geolocation.getCurrentPosition(showPosition, showError, options);
				
				/* 지속적인 위치 갱신이 필요한 경우 위치가 변경될때마다 알려주는 반복위치
				서비스가 필요한 경우 사용한다. 스마트폰으로 모바일웹에 접속한다면 
				이 함수가 유용하다. */
				/* var watchID = navigator.geolocation.watchPosiotion(showPosition, showError, options); */
				//더 이상 위치 갱신이 필요없는 경우 
				/* navigator.geolocation.clearWatch(watchID); */
			} else {
				span.innerHTML = "이 브라우저는 Geolocation API를 지원하지 앖습니다.";
			}
		}
		
		//위치를 찾았을때의 콜백함수 
		var showPosition = function(position){
			console.log("showPosition() 콜백됨");
			//콜백데이터를 통해 위도, 경도를 얻어온다. 
			var latitude = position.coords.latitude;
			var longitude = position.coords.longitude;
			span.innerHTML = "위도:"+ latitude +", 경도:"+longitude;
			
			//<input> 태그에 value로 삽입
			document.getElementById("lat").value = latitude;
			document.getElementById("lng").value = longitude;
		}
		
		//위치를 찾지 못한 경우의 콜백함수 
		var showError = function(error){
			switch(error.code){
			case error.UNKNOWN_ERROR:
				span.innerHTML = "알수 없는 오류 발생"; break;
			case error.PERMISSION_DENIED:
				span.innerHTML = "권한이 없습니다."; break;
			case error.POSITION_UNAVAILABLE:
				span.innerHTML = "위치 확인 불가"; break;
			case error.TIMEOUT:
				span.innerHTML = "시간초과"; break;
			}
		}
		</script>
	</head>
	<body>
	<div class="container">
		<h2>GeoLocation - 현재위치의 위도, 경도 알아내기</h2>
		<fieldset>
			<legend>현재 위치 - 위도, 경도</legend>
			<span id="result" style="color: red; font-size: 1.5em; font-weight: bold;"></span>
		</fieldset>
		
		위도 : <input type="text" id="lat">
		경도 : <input type="text" id="lng">
	</div>
	</body>
</html>