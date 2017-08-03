
  $(function() {
    $("#datepicker-start,#datepicker-end").datepicker({
      dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
      monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      dateFormat: "yy-mm-dd",
      buttonText: "달력"
    });
  });

  var address = $('.addressIn').text()
  
  var titl = $('.titleIn')
  var pric = $('.priceIn')
  var content = $('.promotionText')
  var sdt = $('.dateStart')
  var edt = $('.dateEnd')
//  var sdt = null
//  var edt = null
  var tno = 1
  var lat = 0
  var lng = 0
  var type = 1
  
// 다음맵: 주소 -> 위도, 경도 
  var geocoder = new daum.maps.services.Geocoder();
  var callback = function(result, status) {
    if (status === daum.maps.services.Status.OK) {
        // console.log(result);
        // console.log(result[0]);
        console.log(result[0].y);
        lat = result[0].y
        console.log(result[0].x);
        lng = result[0].x
    }
  };
  geocoder.addressSearch(address, callback);
// 다음맵 끝 
  
  $('.save').on('click', function() {

	  
	  $.post('/promotion/add.json', {
		  'titl' : titl.val(),
		  'pric' : pric.val(),
		  'content' : content.val(),
		  'sdt' : sdt.val(),
		  'edt' : edt.val(),
		  'tno' : tno,
		  'lat' : lat,
		  'lng' : lng,
		  'type' : type
		  
	  }, function(result) {
//	    location.href = '../management/user.html'     
	  }, 'json')
	})
	
	
	