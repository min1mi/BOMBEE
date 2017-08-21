 $(function() {
    $("#datepicker-start").datepicker({
      dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
      monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      dateFormat: "yy-mm-dd D",
      buttonText: "달력",
      minDate: 0
    });
    
    getData(json, no, '')
  })

  var json = '/auth/userinfo.json'
  var no = -1
  var tno = location.href.split('=')[1]
  var pno
  var startDate,
  startDay,
  period,
  time

  function getData(json, no, day) {
    $.getJSON(json, {
      'no': no,
      'day':day
    }, function(result) {
      if (json == '/auth/userinfo.json') {
        if (result.data.membertype == 1) {
          no = result.data.no
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
        startDay = startDate.split(' ')[1]
        period = $('.period').val().split('개월')[0]
    
    console.log(tno, pno, startDate, period, startDay)
//    $.post('', {
//      'tno': tno, 
//      'pno': pno, 
//      'sdt': startDate
//      
//      }, function() {
//        
//    })
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
      startDay = $('.dateStart').val().split(' ')[1]
      console.log(tno)
      getData('/schedule/tcherSelectSchedule.json', tno, startDay)
  })
  
  
  
  
  
  
  
  
  
  
  
  
  //