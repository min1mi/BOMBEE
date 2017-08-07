$.getJSON('/auth/userinfo.json', function(result) {
	no = result.data.no
  getData()
})


function getData() {
  $.getJSON('/trainer/detail.json', {no}, function(result) {
    console.log(result)
    var templateFn = Handlebars.compile($('#detail-template').text())
	  var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
	  var container = $('#detail-container')
	  var html = container.html()
	  container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.      })
  })
}


jQuery(document).ready(function($){

$(".pro-t-Btn").click(function(){
$(".t-t-table").slideToggle(400);
});
})
