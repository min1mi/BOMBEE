$(function() {
  $('.header').load('../menu/new.html')
})

$.ajax({
  url: 'http://localhost:8888/alert/get.json',
  type: 'post',
  data:{no: no},
  dataType:'json',
  success: function(result) {
    console.log(result)
      var templateFn = Handlebars.compile($('#requested-template').text())
      var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
      var container = $('.requested-container')
      container.html("")
      container.html(generatedHTML)
    if(result.length < 0) {
    }
  }
})
      
function btnConnect() {
  $('.cancle').click(function() {
    trano = $(this).attr('data-trano')
    getData('/friend/friendDelete.json', trano)
  })
  console.log(trano)
} 