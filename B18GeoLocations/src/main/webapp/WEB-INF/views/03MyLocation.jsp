<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>03MyLocation</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <style>
      #map{
         width:100%; height:700px;
      }
      </style>
      <script type="text/javascript">
      var span;
      window.onload = function(){
         span = document.getElementById("result");
      
         if(navigator.geolocation){
            span.innerHTML = "Geolocation API를 지원합니다";
            
            var options = {
               enableHighAccury:true,
               timeout:5000,
               maximumAge:3000
            };
            /* navigator.geolocation.getCurrentPosition(showPosition,
                  showError,options); */
            
            var watchID = 
               navigator.geolocation.watchPosition(showPosition, showError, options);
//            navigator.geolocation.clearWatch(watchID);
         }
         else{
            span.innerHTML =
               "이 브라우저는 Geolocation API를 지원하지 않습니다";
         }
      }
      
      var showPosition = function(position){
         var latitude = position.coords.latitude;
         var longitude = position.coords.longitude;
         span.innerHTML = "위도:"+latitude+"경도:"+longitude;
         
         initMap(latitude, longitude);
      }
      
      function initMap(latVar, lngVar) {
         var uluru = {lat: latVar, lng: lngVar};
         var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 17,
            center: uluru
         });
         var marker = new google.maps.Marker({
            position: uluru,
            map: map
         });
      }
      
      var showError = function(error){
         switch(error.code){
            case error.UNKNOWN_ERROR:
               span.innerHTML = "알수없는 오류발생";break;
            case error.PERMISSION_DENIED:
               span.innerHTML = "권한이 없습니다";break;
            case error.POSITION_UNAVAILABLE:
               span.innerHTML = "위치 확인불가";break;
            case error.TIMEOUT:
               span.innerHTML = "시간초과";break;
         }
      }
      </script>
   </head>
   <body>
   <div class="container">
      <h2>GeoLocation - 현재위치의 위도, 경도 알아내기</h2>
      <fieldset>
         <legend>현재위치 - 위도, 경도</legend>
         <span id="result" style="color:red; font-size:1.5em;
            font-weight:bold;"></span>
      </fieldset>
      <div id="map"></div>
      <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=${apiKey }">
      </script>
   </div>
   </body>
</html>