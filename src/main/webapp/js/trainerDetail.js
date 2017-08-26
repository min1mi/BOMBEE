var tno = -1
var tname = -1
var tpci = -1
var no = -1
var json = '/trainer/detail.json'
var lat = 33.450701;
// 위도
var lon = 126.570667;
// 경도
var realpic
var wishtime
var mno = -1
var tno = location.href.split('=')[1]
var pno
var startDate,
startDay,
period,
time
var tname = -1
var mymno = -1
var mname = -1
var membertype = -1
var othername =-1
var othermno = location.href.split('?')[1].split('=')[1].split('#')[0]
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
	$('.header').load('../main/header.html')
	$("#datepicker-start").datepicker({
	      dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	      monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	      monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	      dateFormat: "yy-mm-dd D",
	      buttonText: "달력",
	      minDate: 0
	    });
	
	getData('/auth/userinfo.json', mno, '')
    $( "#accordion" ).accordion();
})

no = location.href.split('?')[1].split('=')[1]
getDatas(json, no, 'trainer-info-template', 'trainer-info-container')
getDatas('/schedule/detail.json', no, '', '')
getDatas('/review/detail2.json', no, 'review-template', 'rev-form')
getDatas('/promotion/promotionTitlePicList.json', no, 'promotionTitle-template', 'img-container')

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
	    	console.log(result)
	    	tno = result.data.no
			tname = result.data.name
			othername = result.data.name
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
	    	
	    }else if (json == '/promotion/promotionTitlePicList.json'){
	    	btnPromotionImgConnect()
	    }
	})
}
function getData(json, no, day) {
    $.getJSON(json, {
      'no': no,
      'day':day
    }, function(result) {
      if (json == '/auth/userinfo.json') {
        if (result.data.membertype == 1) {
          mno = result.data.no
          mymno = result.data.no
      	  mname = result.data.name
      	  membertype = result.data.membertype
          console.log(mno)
          getData('/promotion/promotion.json', tno, '')
        }
      } else if (json == '/promotion/promotion.json') {
        console.log(result.data.list)
        var data = result.data
        var templateFn = Handlebars.compile($('#match-template').text())
        var generatedHTML = templateFn(result.data)
        var container = $('.promotion-container')
        container.html('')
        container.html(generatedHTML)
        
        selectPromotion()
      } else if(json == '/schedule/tcherSelectSchedule.json') {
    	  console.log(result.data)
    	  time = [9,10,11,12,13,14,15,16,17,18,19,20,21]
    	  for (var i = 0; i < time.length; i++) {
    		  for (var j = 0; j < result.data.length; j++) {
    			  if(time[i] == result.data[j].time)
    				  time.splice(i--, 1)
    		  }
    	  }
        var templateFn = Handlebars.compile($('#match-time-template').text())
        var generatedHTML = templateFn(time)
        var container = $('.times')
        container.html('')
        container.html(generatedHTML)
        connectBtn()
        $('.times').toggle()
      }
    })
  }

  function selectPromotion() {
    $('.promotion-list').on('click', function() {
      $('.promotion-list').css('border', '')
      $(this).css('border', '2px solid #f7ac1a')
      pno = $(this).attr('data-pno')
      console.log(pno)
    })
  }
  
  var matchingContainer = $('.matching-container'),
    backscreen = $('.backscreen');

  $('.matchingBtn').on('click', function() {
	  	startDate = $('.dateStart').val().split(' ')[0]
	  	startDay = $('.dateStart').val().split(' ')[1]
        period = $('.period').val().split('개월')[0]
    if(tno == null || pno == null || startDate == null || period == null || startDay == null || wishtime == undefined || mno == -1) {
    	console.log('값을 못넣음')
    	console.log(no)
    	console.log(no ,tno, pno, startDate, period, startDay, wishtime)
    	swal({
		    title:"필수 입력란이 비었습니다.",
		    type: "warning",
		    animation: false,
		    showConfirmButton:false,
		    timer: 1500
	  	  }
		);
    }else {
    console.log("json 요청")
    console.log(mno)
    console.log(mno ,tno, pno, startDate, period, startDay, wishtime)
    insertTcher_trainer('/friend/addReq.json',mno,tno, pno, startDate, period, wishtime)
    }
  })
  
  $('.pro-friend-Btn').on('click', function() {
    if (matchingContainer.attr('data-open') == 'close') {
      backscreen.show()
      matchingContainer.show()
      matchingContainer.attr('data-open', 'open')
    }
    
    backscreen.on('click', function() {
      backscreen.hide()
      matchingContainer.hide()
      matchingContainer.attr('data-open', 'close')
    })
  })
  
    $('.matchBtn').on('click', function() {
    if (matchingContainer.attr('data-open') == 'close') {
      backscreen.show()
      matchingContainer.show()
      matchingContainer.attr('data-open', 'open')
    }
    
    backscreen.on('click', function() {
      backscreen.hide()
      matchingContainer.hide()
      matchingContainer.attr('data-open', 'close')
    })
  })
  
  $('.dateStart').change(function () {
	  $('.times').css('display','none')
      startDay = $('.dateStart').val().split(' ')[1]
      console.log(tno)
      getData('/schedule/tcherSelectSchedule.json', tno, startDay)
  })
  
  function connectBtn() {
	  $('.time-box').click(function() {
		  $('.time-box').removeClass('click')
		  $(this).addClass('click')
		  wishtime= $('.click').attr('value')
		  console.log(wishtime)
	  })
  }
  
  function insertTcher_trainer(json, mno, tno, pno, sdt, period, wishtime) {
	  $.getJSON(json, {
		  'mno':mno,
		  'tno':tno,
		  'pno':pno,
		  'sdt':sdt,
		  'period':period,
		  'wishtime':wishtime
	  }, function(result) {
		  if(othername != -1 && mymno != -1 && othermno != -1) 
			  ajaxNode(1, othername, mymno, "친구요청", othermno)
	    window.history.go(-1)
		  
	  })
  }
  
  
  function ajaxNode(no, othername, mymno, kinds, othermno){
		$.ajax({
			url: 'http://'+ location.host +':8888/alert/add.json',
			type: 'post',
			data:{
				type: no,
				othername: othername,
				mymno: mymno,
				kinds: kinds,
				othermno: othermno
				},
			dataType:'json',
			success: function(result) {
				mymno = -1
				othername =-1
				othermno = -1
				console.log(result)
				location.reload()
			}
		})
	}
  $('.pro-chatting-Btn').on('click', function() {
		realpic = location.host + tpic
		location.href = 'http://'+location.host+':8888/detail-chat.html?myNo=' + mno + '&yourNo='
				+ tno +'&yourName='
				+ tname +'&membertype='
				+ membertype +'&imagePath='+ realpic;
	})

  
$('.more').click(function() {
	if ($(this).attr('value') == 1) {
	  if($(this).text() == '접기') {
	    $(this).text('펼치기')
	    $(this).children('.up').css('display', 'none')
	    $(this).children('.down').css('display', '')
	    
	    
	  } else if($(this).text('펼치기')) {
//	    $(this).text('접기')
//	    $(this).children('.updown').removeClass('fa-angle-down').addClass('fa-angle-up')
	  }
	  
	  $(this).parent().parent().children('table').slideToggle()
	  
	} else if($(this).attr('value') == 2) {
	  $(this).text('펼치기')
	  $(this).children('.updown').removeClass('fa-angle-up').addClass('fa-angle-down')
		$(this).parent().parent().children('#map').slideToggle()
	} else if($(this).attr('value') == 3) {
	  $(this).text('접기')
	  $(this).children('.updown').removeClass('fa-angle-down').addClass('fa-angle-up')
		$(this).parent().parent().children('#rev-form').slideToggle()
	}
})

var swiper = new Swiper('.swiper-container', {
        scrollbar: '.swiper-scrollbar',
        scrollbarHide: true,
        slidesPerView: 'auto',
        centeredSlides: true,
        spaceBetween: 30,
        grabCursor: true,
        observer:true
    });
  
  function btnPromotionImgConnect() {
	  $('.promotion-image').click(function() {
		  location.href = '../promotion/promotionDetail.html?no='+$(this).attr('value')
	  }) 
  }