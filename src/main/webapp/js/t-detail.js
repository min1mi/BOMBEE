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
  })
}


jQuery(document).ready(function($){

$(".pro-t-Btn").click(function(){
$(".t-t-table").slideToggle(400);
});
})
