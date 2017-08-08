$(function() {
  generateTemplate();
});
function generateTemplate() {
  var no = 1// 로그인했을때 자기 MNO tno를 받아와야 된다.
  $.getJSON('/trainer/detail.json', {no}, function(result) {
    console.log(result)
    var templateFn = Handlebars.compile($('#detail-template').text())
    var generatedHTML = templateFn(result.data)
    var container = $('#detail-container')
    var html = container.html()
    container.html(html + generatedHTML)
    console.log(result)
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
  })
}


jQuery(document).ready(function($){

$(".pro-t-Btn").click(function(){
$(".t-t-table").slideToggle(400);
});
})
