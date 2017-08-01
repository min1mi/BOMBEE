
  
var listHeader = $('#list-header')
var mapHeader = $('#map-header')
var trainer = $('#trainer')
var promotion = $('#promotion')
var types = '#map-template'
var address_script = '';
var json = '/promotion/list.json'
var markers = [];
var proObject = []
var spoNo = 0
var imageSrc,
imageSize , // 마커이미지의 크기입니다
imageOprion = {offset: new daum.maps.Point(0, 0)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
//마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage
var marker
var toggleAddr = ''
var proAllObject = []
var seoul = 'http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admCodeList.json?authkey=4c3dd139ed40e85475d902'
var guro = 'http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admSiList.json?authkey=a32d52326f4cd3bd8b9654'
var searchAddr
var promotion = {}
var addClass = $('.add-class')
var btn = $('.btn') //라벨 밑줄 클래스 추가하려고 만듬
var radioBtn = $('.radio-button')
var quit = $('#quit')
var codeContainer = $('#code-container')
var siContainer = $("#si-container")
var dongContainer = $('#dong-container')


var mapContainer = $('#map')[0], // 지도를 표시할 div 
    mapOption = { 
        center: new daum.maps.LatLng(37.494533687556945, 127.02810003919578), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new daum.maps.Map(mapContainer, mapOption); 
var geocoder = new daum.maps.services.Geocoder();
// 주소-좌표 변환 객체를 생성합니다
$('#map').css('height', screen.availHeight-207+'px')

GPSFind()
getData(json, types, '') //처음엔 '#map-template' 스크립트와 생성될 div가 없어서 연결될 애가없음으로 ''을줌
getData(seoul, '#codeList', '#code-container')


function GPSFind(){
	//HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
	if (navigator.geolocation) {
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	        
	        var locPosition = new daum.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = ''; // 인포윈도우에 표시될 내용입니다
	        
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	            
	      });
	    
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    var locPosition = new daum.maps.LatLng(37.494533687556945, 127.02810003919578),    
	        message = 'geolocation을 사용할수 없어요..'
	        
	    displayMarker(locPosition, message);
	}

	// 지도에 마커와 인포윈도우를 표시하는 함수입니다
	function displayMarker(locPosition, message) {

	    // 마커를 생성합니다
	     marker = new daum.maps.Marker({  
	        map: map, 
	        position: locPosition
	    }); 
	    
	    // 지도 중심좌표를 접속위치로 변경합니다
	    map.setCenter(locPosition); 
	}    
}

function mapMarker(address, imageSrc , size, no, check) {
	// 주소로 좌표를 검색합니다

	geocoder.addressSearch(address, function(result, status) {
		//마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다

        markerImage = new daum.maps.MarkerImage(imageSrc, size, imageOprion)
	    // 정상적으로 검색이 완료됐으면 
	     if (status === daum.maps.services.Status.OK) {
	        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new daum.maps.Marker({
	            map: map,
	            position: coords,
	            image: markerImage,
	            clickable: true,
	            title: address
	        });
	     // 생성된 마커를 배열에 추가합니다
	        markers.push(marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        /* map.setCenter(coords); */
	        
	        
	    } 
        daum.maps.event.addListener(marker, 'click', function() {
            // 마커 위에 인포윈도우를 표시합니다
            if(check != 0) {
            	toggleAddr = $(this)[0].Vd

            	$('.list-div').remove()
            	getData(json,  '#list-template', '#addList')
            	$('#click-container').toggle()
            	
            	
            }else {
            	 location.href = '../promotionDetail/promotionDetail.html'
            }
            
      })
	})
}
//배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
function setMarkers(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
    markers = [];
}
  
  Handlebars.registerHelper('marker', function(promotionList, last, options) {
	  promotionList[0].check = 0
	  proObject.push(promotionList[0])
	  proAllObject.push(promotionList[0])
	    if (last) {
    if(spoNo == 0) {
      for (var j=0; j< proObject.length ; j++) {
            for (var i=1; i<proObject.length;  i++) {
              if ( j != i) {
                if (proObject[j].comaddr == proObject[i].comaddr) {
                        proObject[j].check++
                        proObject.slice(i, 1)
                      }
              }
            }
          }
      
      for (var key of proObject) {
             if (key.check > 0) {
               imageSize = new daum.maps.Size(75, 100)
               // 여기부터 
               imageSrc = '../image/multi-marker.png'
               mapMarker(key.comaddr, imageSrc, imageSize, key.no, key.check)
             }else {
               imageSize = new daum.maps.Size(42, 50)
               if(key.type == '1') {
                    imageSrc = '../image/health_marker.PNG'
                  }else if (key.type == '2') {
                    imageSrc = '../image/spinning_marker.PNG'
                  }else if (key.type == '3') {
                    imageSrc = '../image/yoga_marker.PNG'
                  }else 
                    imageSrc = '../image/pilates_marker.PNG'
                  mapMarker(key.comaddr, imageSrc, imageSize, key.no, key.check)
             }
           }
    }else {
      for (var i=0; i < proAllObject.length; i++) {
             for(var j=1;  j < proAllObject.length; j++) {
               if (i != j) {

                 if(proAllObject[i].type == proAllObject[j].type && proAllObject[i].comaddr == proAllObject[j].comaddr) {
                   if (proAllObject[i].type == spoNo) {
                    proAllObject[i].check++ 
                   }
                 }
               }
             }
         }
      for (var key of proAllObject) {
               if (key.check > 0) {
                 imageSize = new daum.maps.Size(75, 100)
                 // 여기부터 
                 imageSrc = '../image/multi-marker.png'
                            // 지우고 파일 imageSrc = '경로만 적어주면됨' 여기까지
                        if (spoNo == 1 && key.type == spoNo) 
                             mapMarker(key.comaddr, imageSrc, imageSize, key.no, key.check)
                        else if (spoNo == 2 && key.type == spoNo) 
                            mapMarker(key.comaddr, imageSrc, imageSize, key.no, key.check)
                        else if (spoNo == 3 && key.type == spoNo) 
                             mapMarker(key.comaddr, imageSrc, imageSize, key.no, key.check)
                        else if (spoNo == 4 && key.type == spoNo) 
                             mapMarker(key.comaddr, imageSrc, imageSize, key.no, key.check)
                 
               }else {
                 imageSize = new daum.maps.Size(42, 50)
                   if(key.type == '1') {
                        imageSrc = '../image/health_marker.PNG'
                      }else if (key.type == '2') {
                        imageSrc = '../image/spinning_marker.PNG'
                      }else if (key.type == '3') {
                        imageSrc = '../image/yoga_marker.PNG'
                      }else 
                        imageSrc = '../image/pilates_marker.PNG'
                        	if (spoNo == 1 && key.type == spoNo) 
                                mapMarker(key.comaddr, imageSrc, imageSize, key.no, key.check)
                           else if (spoNo == 2 && key.type == spoNo) 
                               mapMarker(key.comaddr, imageSrc, imageSize, key.no, key.check)
                           else if (spoNo == 3 && key.type == spoNo) 
                                mapMarker(key.comaddr, imageSrc, imageSize, key.no, key.check)
                           else if (spoNo == 4 && key.type == spoNo) 
                                mapMarker(key.comaddr, imageSrc, imageSize, key.no, key.check)
               }
             }
    }
    return
  }
    }); 
  
Handlebars.registerHelper('type', function(promotionList, options) {
	if (toggleAddr == '') {
	     if (spoNo != 0) {
	         if(spoNo == promotionList[0].type)
	              return options.fn(this);
	           else
	             return options.inverse(this);
	       } else
	         return options.fn(this);
	   }else if(toggleAddr == promotionList[0].comaddr && promotionList[0].type == spoNo) 
	             return options.fn(this);
	   else if (toggleAddr == promotionList[0].comaddr) {
		   if (spoNo == 0)
		    return options.fn(this);
	   }
	  });

function getData(json, type, create) {
    $.getJSON(json, function(result) {
      // 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
		console.log(result)
      var templateFn = Handlebars.compile($(type).text())
      if (type== '#map-template' || type== '#list-template')
    	  var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
      else 
    	  var generatedHTML = templateFn(result)
      var container = $(create)
      var html = container.html()
      container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.   
      if(create == '#addList' || create == '#list-container') {
    	  $('.list-div').click(function() {
    	        location.href = '../promotionDetail/promotionDetail.html'
    	      })
      }
    })
  }

function cityList(type){
	if (type == 'city')
		getData('http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admSiList.json?authkey=a32d52326f4cd3bd8b9654&admCode='+admCode, '#siList', '#si-container')
	else
		getData('http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admSiList.json?authkey=5bde843a55e812c6f1f714&admCode='+admCode, '#siList', '#dong-container')
	}

function searchAddress(searchAddr) {
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(searchAddr, function(result, status) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === daum.maps.services.Status.OK) {

	        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	})
}



mapHeader.click(function (){
	 setMarkers(null)
	mapHeader.css('display', 'none')
	listHeader.css('display', '')
	$('#map').css('display', '')
	$('#list-container').css('display', 'none')
	proObject = []
	proAllObject = []
	getData(json,  '#map-template', '')
})

listHeader.click(function (){
	console.log($('.list-div'))
	$('#click-container').hide()
	console.log($('.list-div'))
	toggleAddr = ''
	$('.list-div').remove()
  listHeader.css('display', 'none')
  mapHeader.css('display', '')
  $('#map').css('display', 'none')
  $('#list-container').css('display', '')
  getData(json,  '#list-template', '#list-container')
})

$(addClass).click(function () {
	$(btn).removeClass('click')
	$(this).parent().addClass('click')
})
$(radioBtn).click(function () {
	setMarkers(null)
	$(radioBtn).removeClass('select')
	$(this).addClass('select')
	 spoNo = $(this).attr('value')
	 proObject = []
	proAllObject = []
	 getData(json,  '#map-template', '')
	 $('.list-div').remove()
	 getData(json,  '#list-template', '#list-container')
})
$(quit).on('click', function () {
	$('#click-container').toggle()
})

$( codeContainer )
  .change(function() {
    admCode=$( "#code-container option:selected").val();
    searchAddr = $("#code-container option:selected").text();
    $('.selected').remove();
    cityList('city');
  })
  $(siContainer)
  .change(function() {
    admCode=$( "#si-container option:selected").val();
    searchAddr += ' '+$("#si-container option:selected").text();
    cityList('dong');
    
    // 동은 옵션에 dong을 주고 누를때마다 삭제하게 만들어야함  $('.dong').remove()사용
  })
  $(dongContainer).change(function() {
	  searchAddr += ' '+$("#si-container option:selected").text();
	  searchAddress(searchAddr)
  })