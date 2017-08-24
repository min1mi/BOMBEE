$(function() {
  $('.header').load('../menu/new.html')
})
var no = null;

$.getJSON('/auth/userinfo.json', function(result) {
  console.log(result)
  if (result.status != 'fail') {
    no = result.data.no
    
    $.ajax({
      url: 'http://' + location.host + ':8888/alert/get.json',
      type: 'post',
      data:{no: no},
      dataType:'json',
      success: function(result) {
        console.log(result)
          var templateFn = Handlebars.compile($('#alram-template').text())
          var generatedHTML = templateFn(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
          var container = $('.alram-info-container')
          container.html("")
          container.html(generatedHTML)
        if(result.length < 0) {
        }
      }
    })
  }
})


      
function btnConnect() {
  $('.cancle').click(function() {
    trano = $(this).attr('data-trano')
    getData('/friend/friendDelete.json', trano)
  })
  console.log(trano)
} 