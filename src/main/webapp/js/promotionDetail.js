
var no = 0
var lat
var lon
var price = $('#promotion_price')

try {
   no = location.href.split('?')[1].substring(3)
   console.log('no:' + no)
} catch (err) {}

// 헤더 로딩
$(document).ready(function() {
  $('.header').load('../menu/new.html')
})

// 맵 마커 시작


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

// swiper 시작
var swiper = new Swiper('.swiper-container', {
    pagination: '.swiper-pagination',
    paginationClickable: true,
    nextButton: '.swiper-button-next',
    prevButton: '.swiper-button-prev',
    observer:true
});
// swiper 끝




$.getJSON('/promotion/detail.json', {'no' : no}, function(result) {
    console.log(result.data.promotion)
    lat = result.data.promotion.lat
    lon = result.data.promotion.lng
    console.log(lat)
    console.log(lon)
    price.text(result.data.promotion.pric)
    
    var templateFn = Handlebars.compile($('#detail-template').text())
    var generatedHTML = templateFn(result.data.promotion) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
    var container = $('#handlebars-pro-detail')
    var html = container.html()
    container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.


    // 이미지 템플릿 처리
    var templateFn2 = Handlebars.compile($('#swiper-template').text())
    var generatedHTML2 = templateFn2(result.data.promotion) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
    var container2 = $('#swiper-detail')
    var html2 = container2.html()
    container2.html(html2 + generatedHTML2) // 새 tr 태그들로 설정한다.
    // 이미지 템플릿 끝

   var acc = document.getElementsByClassName("accordion");
   mapCreate()

    acc[0].onclick = function() {
        this.classList.toggle("active");
        var panel = this.nextElementSibling;
        if (panel.style.maxHeight){
          panel.style.maxHeight = null;
        } else {
          panel.style.maxHeight = panel.scrollHeight + "px";
        }

      }

  })
