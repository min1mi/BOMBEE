
  $(function() {
    $("#datepicker-start,#datepicker-end").datepicker({
      dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
      monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      dateFormat: "yy-mm-dd",
      buttonText: "달력"
    });
  });
  var addrInput = $('.addressIn')
  var addrComp = $('.addressCompany')
  
  var title = $('.titleIn')
  var pric = $('.priceIn')
  var content = $('.promotionText')
  var sdt = $('.dateStart')
  var edt = $('.dateEnd')
  var tno = 1
  var lat = 0
  var lng = 0
  var type = 1
  
  var img =111
  
// 다음맵: 주소 -> 위도, 경도 
  var geocoder = new daum.maps.services.Geocoder();
  var callback = function(result, status) {
    if (status === daum.maps.services.Status.OK) {
        lat = result[0].y
        lng = result[0].x
    }
  };
  
// 다음맵 끝 
  
  $('.save').on('click', function() {
	  console.log('save click')
	  $.post('/promotion/add.json', {
		  'title' : title.val(),
		  'pric' : pric.val(),
		  'content' : content.val(),
		  'sdt' : sdt.val(),
		  'edt' : edt.val(),
		  'tno' : tno,
		  'lat' : lat,
		  'lng' : lng,
		  'type' : type,
		  'img' : img
		  
		  
	  }, function(result) {
//	    location.href = '../management/user.html'     
	  },'json')
	})
	
	$.getJSON('/auth/userinfo.json', function(result) {
	  console.log(result.data.membertype)
	  if(result.data.membertype == 1)
		  location.href = '../auth/login.html'
		else {
			console.log(result.data)
			addrInput.text(result.data.comaddr)
			addrComp.text(result.data.comname)
			geocoder.addressSearch(result.data.comaddr, callback);
		}
})
	

	