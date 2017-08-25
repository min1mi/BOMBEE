var tno = -1
var tname = -1
var tpci = -1
var no = -1
var json = '/trainer/detail.json'
var lat = 33.450701;
// 위도
var lon = 126.570667;
// 경도
function mapCreate() {
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
	mapOption = {
		center: new daum.maps.LatLng(lat, lon), // 지도의 중심좌표
		level: 5 // 지도의 확대 레벨
	};
	var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	//// 여기 까지 기본 맵
	// 마커가 표시될 위치입니다
	var markerPosition  = new daum.maps.LatLng(lat, lon);
	// 마커를 생성합니다
	var marker = new daum.maps.Marker({
		position: markerPosition
	});
	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
	////여기까지 마커 */
}

//  mapCreate 호출

var geocoder = new daum.maps.services.Geocoder();

var callback = function(result, status) {
    if (status === daum.maps.services.Status.OK) {
        lat = result[0].address.y
        lon = result[0].address.x
        mapCreate()    }
};


$(document).ready(function() {
	$('.header').load('../menu/new.html')
})

no = location.href.split('?')[1].split('=')[1]
getDatas(json, no, 'trainer-info-template', 'trainer-info-container')
getDatas('/schedule/detail.json', no, '', '')
getDatas('/review/detail2.json', no, 'review-template', 'rev-form')

function getDatas(json, no, template, containers) {
	console.log(template)
	$.getJSON(json, {no}, function(result) {
		console.log(result)
		if(template != '' && containers != '') {
			var templateFn = Handlebars.compile($('#'+template).text())
			var generatedHTML = templateFn(result.data)
			var container = $('#'+containers)
			var html = container.html()
			console.log(html)
			container.html(html + generatedHTML)
		}
	    
	    if(json == '/trainer/detail.json') {
	    	tno = result.data.no
			tname = result.data.name
			tpic = result.data.tcherpic
			geocoder.addressSearch(result.data.comaddr, callback);
			switch (result.data.spono){
			case "1" :
				$('.t-spono').text('요가')
				break;
			case "2" :
				$('.t-spono').text('헬스')
				break;
			case "3" :
				$('.t-spono').text('스피닝')
				break;
			case "4" :
				$('.t-spono').text('필라테스')
				break;
			default :
				console.log("선택하세요")
			}
	    }else if(json == '/schedule/detail.json') {
	    	var bookNo = result.data.weeklist.day+result.data.weeklist.time,
	    	weeklist = result.data.weeklist
	    	for (var week of weeklist) {
	    		bookNo = week.day+week.time
	    		$('td[data-bookno=' + bookNo + ']').addClass('ok')
	    	}
	    }else if (json == '/review/detail2.json') {
	    	
	    }
	})
}

$('.more').click(function() {
	if ($(this).attr('value') == 1)
		$(this).parent().parent().children('table').slideToggle()
	else if($(this).attr('value') == 2)
		$(this).parent().parent().children('#map').slideToggle()
	else if($(this).attr('value') == 3)
		$(this).parent().parent().children('#rev-form').slideToggle()
})

var swiper = new Swiper('.swiper-container', {
        scrollbar: '.swiper-scrollbar',
        scrollbarHide: true,
        slidesPerView: 'auto',
        centeredSlides: true,
        spaceBetween: 30,
        grabCursor: true
    });