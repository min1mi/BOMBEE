$(function() {
  $('.header').load('../main/header.html')
})
var no = null;
var json = '/auth/userinfo.json'
no = location.href.split('?')[1].split('=')[1].split('#')[0]
getData(json, no)
function getData(json, no) {
	if(json == '/auth/userinfo.json') {
	$.getJSON(json,{no}, function(result) {
		  console.log(result)
		  if(json == '/auth/userinfo.json') {
			  if (result.status != 'fail') {
				  no = result.data.no
				  json = '/alert/get.json'
				 ajaxNode('/alert/get.json', no)
			  }
		  }
		})
	}
}

  
function btnConnect() {
  $('.cancle').click(function() {
    var alno = $(this).attr('data-alno')
    ajaxNode('/alert/delete.json', alno)
  })
} 
function ajaxNode(json, no) {
	$.ajax({
		  url: 'http://' + location.host + ':8888'+json,
		  type: 'post',
		  data:{no: no},
		  dataType:'json',
		  success: function(result) {
			  console.log(result)
			  if(result == 0) 
			    $('.no-alram').css('display', '')
			  
			  if(json == '/alert/get.json'){
				  var templateFn = Handlebars.compile($('#alram-template').text())
				  var generatedHTML = templateFn(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
				  var container = $('.alram-info-container')
				  container.html("")
				  container.html(generatedHTML)
			  }else if(json == '/alert/delete.json')
				  location.reload()
			  btnConnect()
		  }
	  })
}