$(function() {
  $('.header').load('../menu/new.html')
})
var no = null;
var json = '/auth/userinfo.json'

function getData(json, no) {
	$.getJSON(json,{no}, function(result) {
		  console.log(result)
		  if(json == '/auth/userinfo.json') {
			  if (result.status != 'fail') {
				  no = result.data.no
			  }
		  }else if (json == '/friend/friendDelete.json') {
			  location.reload()
		  }
		  
		  $.ajax({
			  url: 'http://' + location.host + ':8888'+json,
			  type: 'post',
			  data:{no: no},
			  dataType:'json',
			  success: function(result) {
				  console.log(result)
				  if(json == '/auth/userinfo.json'){
					  var templateFn = Handlebars.compile($('#alram-template').text())
					  var generatedHTML = templateFn(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
					  var container = $('.alram-info-container')
					  container.html("")
					  container.html(generatedHTML)
				  }
				  btnConnect()
			  }
		  })
		})
}

  
function btnConnect() {
  $('.cancle').click(function() {
    trano = $(this).attr('data-trano')
    getData('/friend/friendDelete.json', trano)
  })
  console.log(trano)
} 