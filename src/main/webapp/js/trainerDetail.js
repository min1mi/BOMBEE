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
var tno = parseInt(location.href.split('=')[1])
var pno = null
var trano = null
var protitle
var startDate,
startDay,
period,
time,
fiScore // 별 스코어
var tname = -1
var othermno = -1
var mname = -1
var membertype = -1
var othername =-1
var mymno = location.href.split('?')[1].split('=')[1].split('#')[0]
var myDeleteBtn = -1
var backscreenType = 0
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
	
	/* 1. Visualizing things on Hover - See next part for action on click */
	  $('#stars li').on('mouseover', function(){
	    var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on
	   
	    // Now highlight all the stars that's not after the current hovered star
	    $(this).parent().children('li.star').each(function(e){
	      if (e < onStar) {
	        $(this).addClass('hover');
	      }
	      else {
	        $(this).removeClass('hover');
	      }
	    });
	    
	  }).on('mouseout', function(){
	    $(this).parent().children('li.star').each(function(e){
	      $(this).removeClass('hover');
	    });
	  });
	  
	  
	  /* 2. Action to perform on click */
	  $('#stars li').on('click', function(){
	    var onStar = parseInt($(this).data('value'), 10); // The star currently selected
	    var stars = $(this).parent().children('li.star');
	    
	    for (i = 0; i < stars.length; i++) {
	      $(stars[i]).removeClass('selected');
	    }
	    
	    for (i = 0; i < onStar; i++) {
	      $(stars[i]).addClass('selected');
	    }
	    
	    // JUST RESPONSE (Not needed)
	    fiScore = parseInt($('#stars li.selected').last().data('value'), 10);
	    
	    return fiScore;
	    
	  });
	  
	  ///////////////////////E
})

getData('/auth/userinfo.json', mno, '')
no = location.href.split('?')[1].split('=')[1]
getDatas(json, no, 'trainer-info-template', 'trainer-info-container')
getDatas('/schedule/detail.json', no, '', '')
getDatas('/review/detail2.json', no, 'review-template', 'r-r-inner')
getDatas('/promotion/promotionTitlePicList.json', no, 'promotionTitle-template', 'img-container')
function getDatas(json, no, template, containers) {
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
	    	console.log(myDeleteBtn)
	    	if($('.'+myDeleteBtn))
				$('.'+myDeleteBtn).css('display', '')
			reviewBtn()
	    }else if (json == '/promotion/promotionTitlePicList.json'){
	    	btnPromotionImgConnect()
	    }
	})
}
function getData(json, no, day) {
    $.getJSON(json, {
      no: no,
      day:day
    }, function(result) {
      if (json == '/auth/userinfo.json') {
        if (result.data.membertype == 1) {
          mno = result.data.no
          othermno = result.data.no
          myDeleteBtn = result.data.no
          othername = result.data.name
      	  mname = result.data.name
      	  membertype = result.data.membertype
      	  getData('/review/canReviewList.json', mno, tno)
        }
      } else if (json == '/promotion/promotion.json' || json == '/review/canReviewList.json') {
    	  for(var i = 0; i < result.data.list.length; i++) {
    		  if(undefined ==result.data.list[i].trano)
    			  result.data.list[i].trano = null
    	  }
    	  var cont
    	  if(json == '/promotion/promotion.json')
    		  cont = '.promotion-container'
    	  else if (json == '/review/canReviewList.json') {
    		  if(result.data.list.length != 0) {
    			  cont = '.select-promotion-container'
    			 $('.button').addClass('button1')
    			 $('.button1').removeClass('button')
    			 $('.pro-review-Btn').css('display', '')
    		  }else if(result.data.list.length == 0) {
    			  ;
    		  }
    	  }
    	console.log(cont)
        console.log(result.data)
        var data = result.data
        var templateFn = Handlebars.compile($('#match-template').text())
        var generatedHTML = templateFn(result.data)
        var container = $(cont)
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
      } else if(json == '/review/delete.json') {
    	  location.reload()
      } else if(json == '/review/canReviewList') {
    	  console.log("-----------------")
    	  console.log(result)
      }
    })
  }


  function selectPromotion() {
    $('.promotion-list').on('click', function() {
      $('.promotion-list').css('border', '')
      $(this).css('border', '2px solid #f7ac1a')
      pno = $(this).attr('data-pno')
      if(backscreenType == 2) {
    	  protitle = $(this).children('.promotion-name').text()
    	  trano = $(this).attr('data-trano')
      }
    })
  }
  
  var matchingContainer = $('.matching-container'),
    backscreen = $('.backscreen'),
    reviewSelect = $('.review-select-container'),
    reviewWriteCon = $('.review-write-container')
    
    

  $('.matchingBtn').on('click', function() {
	  	startDate = $('.dateStart').val().split(' ')[0]
	  	startDay = $('.dateStart').val().split(' ')[1]
        period = $('.period').val().split('개월')[0]
    if(tno == null || pno == null || startDate == null || period == null || startDay == null || wishtime == undefined || mno == -1) {
    	swal({
		    title:"필수 입력란이 비었습니다.",
		    type: "warning",
		    animation: false,
		    showConfirmButton:false,
		    timer: 1500
	  	  }
		);
    }else 
    insertTcher_trainer('/friend/addReq.json',mno,tno, pno, startDate, period, wishtime)
  })
  
  $('.reviewWrite').on('click', function() {
  if(trano == null ) {
  	swal({
		    title:"개인트레이너 프로모션을 선택하세요",
		    type: "warning",
		    animation: false,
		    showConfirmButton:false,
		    timer: 1500
	  	  }
		);
  }else {
	  if(reviewWriteCon.attr('data-open') == 'close') {
		  reviewSelect.hide()
		  reviewWriteCon.show()
		  reviewWriteCon.attr('data-open', 'open')
		  $('.review-text-container').focus()
	  }
  }
//  insertTcher_trainer('/friend/addReq.json',mno,tno, pno, startDate, period, wishtime)
})


$('.reviewAdd').on('click', function() {
	console.log($('.review-text-container').val())
    $.post('/review/add.json', {
      'score' : fiScore,
      'review': $('.review-text-container').val(),
      'trano': trano,
      'title':protitle,
      'pno':pno
    }, function(result) {
    	$.post('/review/boolean.json', {
    		'trano' : trano
    	},function(result) {
    	    location.reload()
    	    }, 'json')
    }, 'json')
  
})



  $('.pro-friend-Btn').on('click', function() {
	  getData('/promotion/promotion.json', tno, 1)
    if (matchingContainer.attr('data-open') == 'close') {
      backscreen.show()
      backscreenType = 1
      matchingContainer.show()
      matchingContainer.attr('data-open', 'open')
    }
  })
  
    $('.matchBtn').on('click', function() {
    if (matchingContainer.attr('data-open') == 'close') {
      backscreen.show()
      matchingContainer.show()
      matchingContainer.attr('data-open', 'open')
    }
  })
  
  backscreen.on('click', function() {
	  backscreen.hide()
		  if(backscreenType == 2) {
			  reviewSelect.hide()
			  reviewSelect.attr('data-open', 'close')
			  reviewWriteCon.hide()
			  reviewWriteCon.attr('data-open', 'close')
		  }else if(backscreenType == 1) {
			  matchingContainer.hide()
			  matchingContainer.attr('data-open', 'close')
		  }
		  
		  backscreenType == 0
		  pno = null
		  protitle = null
		  trano = null
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
	    location.reload()
		  
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
	 $(this).children('.fa').toggleClass( 'fa-angle-down', 'fa-angle-up')
	if ($(this).attr('value') == 1) 
	  $(this).parent().parent().children('table').slideToggle()
	 else if($(this).attr('value') == 2) 
		$(this).parent().parent().children('#map').slideToggle()
	 else if($(this).attr('value') == 3) ;
		$(this).parent().parent().children('#r-r-table').slideToggle()
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
  
  function reviewBtn() {
		$('.rev-delete').click(function() {
			getData('/review/delete.json', $(this).attr('data-review'), '')
		})
	}
  
  Handlebars.registerHelper('isScore', function(score ,options) {
	  var empty = 5
	  var str = ''
	  empty -= score
	  for(var i = 1; i <= score; i++) 
		  str += "<i class='fa fa-star' aria-hidden='true'></i>"
    if (empty != 0) {
    	for (var i = 1; i <= empty; i++) 
    		str += "<i class='fa fa-star-o' aria-hidden='true'></i>"
    }
    return (options.fn(this)+str)
  });
  

  $('.pro-review-Btn').click(function() {
	  getData('/review/canReviewList.json', mno, tno)
	  if (reviewSelect.attr('data-open') == 'close') {
		  backscreenType = 2
		  backscreen.show()
		  reviewSelect.show()
		  reviewSelect.attr('data-open', 'open')
	  }
  })
  