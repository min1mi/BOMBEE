 $(function() {
    $("#datepicker-start").datepicker({
      dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
      monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      dateFormat: "yy-mm-dd",
      buttonText: "달력",
      minDate: 0
    });
    
    getData(json, no)
  })

  var json = '/auth/userinfo.json'
  var no = -1
  var tno = location.href.split('=')[1]
  var pno

  function getData(json, no) {
    $.getJSON(json, {
      'no': no
    }, function(result) {
      if (json == '/auth/userinfo.json') {
        if (result.data.membertype == 1) {
          no = result.data.no
          getData('/promotion/promotion.json', tno)
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
    var startDate = $('.dateStart').val(),
        period = $('.period').val().split('개월')[0]
    
    console.log(tno, pno, startDate, period)
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
  
  
  
  
  
  
  
  
  
  
  
  
  
  //