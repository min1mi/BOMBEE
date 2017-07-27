$(function() {
  moment().format();
  $('.header').load('../menu/new.html')

var swiper = new Swiper('.swiper-container', {
  callback: function() {
    swipeCalendar()
  }
});
  generateTemplate();

  date(current)

  dateClick();

  $('#btttn').on('click', function() {
    swipeCalendar()
  })
});


function generateTemplate() {
  $.getJSON('../json/user.json', function(result) {
    // 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
    var templateFn = Handlebars.compile($('#user-template').text())
    var generatedHTML = templateFn(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
    var container = $('#user-container')
    var html = container.html()
    container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.      })


    autoSelect(current)
  })
}

function dateClick() {
  var tabClick = $(".tab-slider--nav .tab-slider--tabs div")
  tabClick.click(function() {
    $(".tab-slider--body").hide();
    var activeTab = $(this).attr("rel");
    $("#"+activeTab).fadeIn();
    if($(this).attr("rel") == "day1"){
      $('.tab-slider--tabs').addClass('slide1');
    } else if($(this).attr("rel") == "day2"){
      $('.tab-slider--tabs').addClass('slide2');
    } else if($(this).attr("rel") == "day3"){
      $('.tab-slider--tabs').addClass('slide3');
    } else if($(this).attr("rel") == "day4"){
      $('.tab-slider--tabs').addClass('slide4');
    } else if($(this).attr("rel") == "day5"){
      $('.tab-slider--tabs').addClass('slide5');
    } else if($(this).attr("rel") == "day6"){
      $('.tab-slider--tabs').addClass('slide6');
    } else {
      $('.tab-slider--tabs')
        .removeClass('slide1 slide2 slide3 slide4 slide5 slide6');
    }
    tabClick.removeClass("active");
    $(this).addClass("active");
  });

  console.log('dateClick()')
}

function autoSelect(moment) {
  var dayNo = moment.weekday()
  $('.tab-slider--tabs').removeClass('slide1 slide2 slide3 slide4 slide5 slide6');
  $(".tab-slider--body").hide();
  if(dayNo == 0) {
    $('.day0').addClass("active");
    $("#day0").show();
  } else if(dayNo == 1){
    $('.tab-slider--tabs').addClass('slide1');
    $('.day1').addClass("active");
    $("#day1").show();
  } else if(dayNo == 2){
    $('.tab-slider--tabs').addClass('slide2');
    $('.day2').addClass("active");
    $("#day2").show();
  } else if(dayNo == 3){
    $('.tab-slider--tabs').addClass('slide3');
    $('.day3').addClass("active");
    $("#day3").show();
  } else if(dayNo == 4){
    $('.tab-slider--tabs').addClass('slide4');
    $('.day4').addClass("active");
    $("#day4").show();
  } else if(dayNo == 5){
    $('.tab-slider--tabs').addClass('slide5');
    $('.day5').addClass("active");
    $("#day5").show();
  } else if(dayNo == 6){
    $('.tab-slider--tabs').addClass('slide6');
    $('.day6').addClass("active");
    $("#day6").show();
  }

  console.log('autoSelect(current)')
}

var months = ["January","February","March",
              "April","May","June","July",
              "August","September","October",
              "November","December"],
    current = moment(new Date());

function date(moment) { // get current date
 var sunDate = moment.clone(),
     month = months[current.get('month')];

  sunDate.add('days', -moment.weekday())

  $('.year').html(current.get('year'));
  $('.month').html(month);

for (var i = 0; i < 7; i++) {
  $('.day' + i).html(sunDate.date())
  sunDate.add('days', 1)
  }
console.log('date(current)')
}

function swipeCalendar() {
  date(current.weekday(7))
}

function inputMeal() {
  $('.input-food-container').toggle()
}




// $('#calendar').datepicker({
//   dayNames: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
//   dayNamesMin: ["일", " 월", " 수", " 목", " 금", " 토", " 일"],
//   format: "mm-yyyy",
//   viewMode: "months",
//   minViewMode: "months",
//   showWeek: true,
//   onSelect: function(dateText, inst) {
//     var date = $(this).datepicker('getDate'),
//         day  = date.getDate(),
//         month = date.getMonth() + 1,
//         year =  date.getFullYear();
//     alert(day + '-' + month + '-' + year);
//   }
// });
// $("#calendar").datepicker("setDate", new Date());
