 $(function() {
    $("#datepicker-start").datepicker({
      dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
      monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      dateFormat: "yy-mm-dd D",
      buttonText: "달력",
      minDate: 0
    });
    
    getData(json, mno, '')
    $( "#accordion" ).accordion();
  })
  var wishtime
  var json = '/auth/userinfo.json'
  var mno = -1
  var tno = location.href.split('=')[1]
  var pno
  var startDate,
  startDay,
  period,
  time
  var othername =-1
  var mymno = location.href.split('?')[1].split('=')[1].split('#')[0]

  function getData(json, no, day) {
    $.getJSON(json, {
      'no': no,
      'day':day
    }, function(result) {
      if (json == '/auth/userinfo.json') {
        if (result.data.membertype == 1) {
          mno = result.data.no
          othername = result.data.name
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
//    $.post('', {
//      'tno': tno, 
//      'pno': pno, 
//      'sdt': startDate
//      
//      }, function() {
//        
//    })
  })
  
  $('.pro-fa-Btn').on('click', function() {
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
		  if(othername != -1 && mymno != -1) 
			  ajaxNode(1, othername, mymno, "친구요청")
		othername = -1
		mymno = -1
	    window.history.go(-1)
		  
	  })
  }
  
  
  function ajaxNode(no, othername, mymno, kinds){
		$.ajax({
			url: 'http://'+ location.host +':8888/alert/add.json',
			type: 'post',
			data:{
				type: no,
				othername: othername,
				mymno: mymno,
				kinds: kinds
				},
			dataType:'json',
			success: function(result) {
				mymno = -1
				othername =-1
				console.log(result)
				location.reload()
			}
		})
	}
  
  
  
  
  
  
  
  //