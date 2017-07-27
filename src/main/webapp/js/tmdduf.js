$(function() {
  $('.header').load('../menu/new.html')


  generateTemplate();


});

function generateTemplate() {
  $.getJSON('../json/tmdduf.json', function(result) {
    // 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
    var templateFn = Handlebars.compile($('#tmdduf-template').text())
    var generatedHTML = templateFn(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
    var container = $('#tmdduf-container')
    var html = container.html()
    container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.      })

    clickPro();
    clickPro1();
  })
}
function clickPro() {
  $(".pro1 .pro div").click(function() {
      console.log($(this).val())
        if(($(this).attr("value")) == "off"){
          $(this).addClass('click')
          $(this).attr("value","on")
        }
        else if(($(this).attr("value")) == ""){
          $(this).addClass('click')
          $(this).attr("value","on")
        }
        else if (($(this).attr("value")) == "on"){
          $(this).removeClass('click')
          $(this).attr("value","off")
        }
      })
}
function clickPro1() {
$("#tmdduf-container div").click(function(){
    // $(".pro1 .pro div").css('');
    $(".pro1 .pro").hide();
    $(this).children().show();

    // $(".pro").hide();
  console.log($(this));
// $(this).slideToggle(1000);
})
}
