var mapContainer = document.getElementById('map'),
    mapOption = {
	  center: new daum.maps.LatLng(37.494522499999995, 127.02760939999999),
	  level: 5
    };

var map = new daum.maps.Map(mapContainer, mapOption);
var places = new daum.maps.services.Places();
var infowindow = new daum.maps.InfoWindow({zIndex:1});

var markers = [];

//지도 확대 축소를 제어할 수 있는 줌 컨트롤을 생성
var zoomControl = new daum.maps.ZoomControl();
map.addControl(zoomControl, daum.maps.ControlPosition.LEFT);

var overlay;

//현재위치정보 가져오기
navigator.geolocation.getCurrentPosition(function(position) {
  var latitude = position.coords.latitude;
  var longitude = position.coords.longitude;
	  
  var locPosition = new daum.maps.LatLng(latitude, longitude);
	  
  //마커 이미지를 생성 관    
  var imageSrc = "http://i1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
  var imageSize = new daum.maps.Size(24, 35);
  var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize); 
  var marker = new daum.maps.Marker({
    map: map, // 마커를 표시할 지도
	position: new daum.maps.LatLng(latitude, longitude),
	image : markerImage // 마커 이미지 
  });
  // 마커가 지도 위에 표시되도록 설정합니다
  marker.setMap(map);
	  

  places.keywordSearch({
    keyword: '카센터',
    callback: placesSearchCB,
    radius: 1000,
    location: locPosition
  });
});
					  
// 키워드 검색 완료 시 호출되는 콜백함수
function placesSearchCB(status, result) {
  if (status === daum.maps.services.Status.OK) {
    // LatLngBounds 객체에 좌표를 추가합니다				          
    var bounds = new daum.maps.LatLngBounds();
			          
    for (var i = 0; i < result.places.length; i++) {
      //마커 표시하는 함수 호출
      displayMarker(result.places[i]);
      
      //영역 정보 확장
      bounds.extend(new daum.maps.LatLng(result.places[i].latitude, result.places[i].longitude));
      
      //리스트 출력
      $("<li class='center'><br>" 
    	  + "<label class='centertitle'>" + result.places[i].title + "</label><br>" 
    	  + "<label class='address'>" + result.places[i].address + "</label><br>" 
    	  + "<label class='phone'>" + result.places[i].phone + "</label>" 
    	  + "<label class='imageUrl' hidden>" + result.places[i].imageUrl + "</label>" 
    	  + "<label class='newAddress' hidden>" + result.places[i].newAddress + "</label>" 
    	  + "<label class='placeUrl' hidden>" + result.places[i].placeUrl + "</label>" 
    	  + "<label class='lat' hidden>" + result.places[i].latitude + "</label>" 
    	  + "<label class='lon' hidden>" + result.places[i].longitude + "</label>" 
    	  + "<br></li>").appendTo($("#centerList"));
    }

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
  } 
}

function displayMarker(place) {
  var marker = new daum.maps.Marker({
    map: map,
    clickable: true,
    position: new daum.maps.LatLng(place.latitude, place.longitude)
  });
    
  markers.push(marker);
   
  daum.maps.event.addListener(marker, 'mouseover', function() {
    // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
    infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.title + '</div>');
    infowindow.open(map, marker);
  });
  
  daum.maps.event.addListener(marker, 'mouseout', function() {
    infowindow.close();
  });
 
  //커스텀 오버레이에 표시할 컨텐츠
  var content = '<div class="wrap">' + 
                  '<div class="info">' + 
                    '<div class="title">' + place.title + 
                      '<div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
                    '</div>' + 
                    '<div class="body">' + 
                      '<div class="img">' +
                        '<img src="' + place.imageUrl + '" width="73" height="70">' +
                      '</div>' + 
                      '<div class="desc">' + 
                        '<div class="ellipsis">' + place.address +'</div>' + 
                        '<div class="ellipsis">' + place.phone +'</div>' + 
                        '<div class="jibun ellipsis">' + place.newAddress + '</div>' +                   
                        '<div><a href="'+ place.placeUrl + '" target="_blank" class="link">홈페이지</a></div>' + 
                      '</div>' + 
                    '</div>' + 
                  '</div>' +    
                '</div>';
  	
  //마커를 클릭했을 때 커스텀 오버레이를 표시
  daum.maps.event.addListener(marker, 'click', function() {
	if (overlay != null) { 
      overlay.setMap(null);
    }
	  	
	//마커 위에 커스텀오버레이를 표시합니다
	//마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
	overlay = new daum.maps.CustomOverlay({
	  	        content: content,
	  	        map: map,
	  	        position: marker.getPosition()       
	   	      });

 	map.panTo(marker.getPosition());
  	overlay.setMap(map);
  });
}
  
//커스텀 오버레이를 닫기 위해 호출되는 함수
function closeOverlay() {
  overlay.setMap(null);     
}
 	
//클릭 이벤트 관련 함수
$("#centerList").on("click","li", function(e) {
  console.log($(".title").eq($(this).index()).text());
	
  var content = '<div class="wrap">' + 
                  '<div class="info">' + 
                    '<div class="title">' + $(".centertitle").eq($(this).index()).text() + 
                      '<div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
                    '</div>' + 
                    '<div class="body">' + 
                      '<div class="img">' +
                        '<img src="' + $(".imageUrl").eq($(this).index()).text() + '" width="73" height="70">' +
                      '</div>' + 
                      '<div class="desc">' + 
                        '<div class="ellipsis">' + $(".address").eq($(this).index()).text() +'</div>' + 
                        '<div class="ellipsis">' + $(".phone").eq($(this).index()).text() +'</div>' + 
                        '<div class="jibun ellipsis">' + $(".newAddress").eq($(this).index()).text() + '</div>' +                   
                        '<div><a href="'+ $(".placeUrl").eq($(this).index()).text() + '" target="_blank" class="link">홈페이지</a></div>' + 
                      '</div>' + 
                    '</div>' + 
                  '</div>' +    
                '</div>';

  var position = new daum.maps.LatLng($(".lat").eq($(this).index()).text(), $(".lon").eq($(this).index()).text());
  
  if (overlay != null) { 
    overlay.setMap(null);
  }

  overlay = new daum.maps.CustomOverlay({
              content: content,
              map: map,
              position: position     
            });

  map.panTo(position);
  overlay.setMap(map);    
});