<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>02GoogleMap.jsp</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

		<style>
		#map{
			width:800px; height:600px;
		}
		</style>
		<script>
		function initMap() {
			var uluru = {lat:37.4898688, lng:126.4975872};
			var map = new google.maps.Map(document.getElementById('map'), {
				zoom: 17,
				center: uluru
			});
			var marker = new google.maps.Marker({
				position: uluru,
				map: map
			});
		}
		window.onload = function(){
			initMap();
		}
		</script>
	</head>
	<body>
	<div class="container">
		<h2>Google Map 띄워보기</h2>
		<div id="map"></div>
		<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=${apiKey}"></script>
	</div>
	</body>
</html>