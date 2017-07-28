$(function() {
  $('.header').load('../menu/new.html')


  generateTemplate();
  // $(".pro1 .pro").hide();

});
// var foseja;

 // console.log(Math.floor(Math.random() * letters.length))
 // foseja = color;
  // $('#wrap').on("click", function(){
  //     $('#wrap').css('background-color', color);
  // })
// ).document.getElementById('wrap').style.background = color; // 조립한 컬러를 프론트엔드에서 지정한 ID에 적용한다



function generateTemplate() {
  $.getJSON('../json/tmdduf.json', function(result) {
    // 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
    var templateFn = Handlebars.compile($('#tmdduf-template').text())
    var templateFn1 = Handlebars.compile($('#tmdduf1-template').text())
    var generatedHTML = templateFn(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
    var generatedHTML1 = templateFn1(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
    var container = $('#tmdduf-container')
    var container1 = $('#tmdduf1-container')
    var html = container.html()
    container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.      })
    var html1 = container1.html()
    container1.html(html1 + generatedHTML1) // 새 tr 태그들로 설정한다.      })

    clickPro();
    clickPro1();
    $("#tmdduf-container #mon").css("background-color","#f7ac1a");
    $("#tmdduf-container #mon .pro").show();
  })
}
function clickPro() {

  $(".pro1 .pro div").click(function() {
      // console.log($(this).val())
        if(($(this).attr("value")) == "off"){
          $(this).attr('id', "click")
          // $(this).attr('id', "click")
          $(this).attr("value","on")
        }
        else if(($(this).attr("value")) == ""){
          $(this).attr('id', "click")
          // $(this).addID('click')
          $(this).attr("value","on")
        }
        else if (($(this).attr("value")) == "on"){
          // $(this).removeClass('click')
          $(this).attr('id', "")
          $(this).attr("value","off")
        }
      })
}
function clickPro1() {
$("#tmdduf-container div").click(function(){
    $(".pro1 .pro").hide();
    $(".pro1").css("background-color","#35484f");
    $(this).css("background-color", "#f7ac1a");
    // console.log(this)
    // $(this).css("background-color", color);
    $(this).children().show();
    // $(this).slideToggle(1000);


})
}
