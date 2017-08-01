$(function() {
  moment().format();
  $('.header').load('../menu/new.html')

  generateTemplate();

  date(current);

  dateClick();
  slideDate();


});


var startDate,
endDate;

function generateTemplate() {
  startDate = current.startOf('week').format("YYYY-MM-DD")
  endDate = current.endOf('week').format("YYYY-MM-DD")
  $.getJSON('usermeal-list.json', {"startDate": startDate,
    "endDate": endDate}, function(result) {
      console.log(result.data.mealList)


      // 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
      for (var dayMeal of result.data.mealList) {
        var sortedMeals = [];
        for (var meal of dayMeal.meal) {
          switch (meal.mealtype) {
          case "breakfast": sortedMeals[0] = meal; break;
          case "lunch": sortedMeals[1] = meal; break;
          case "dinner": sortedMeals[2] = meal; break;
          }
        }

        for (var i = 0; i < 3; i++) {
          if (!sortedMeals[i]) sortedMeals[i] = null
        }
        dayMeal.sortedMeals = sortedMeals;
      }
      
      var mealList = result.data.mealList
      var templateFn = Handlebars.compile($('#user-template').text())
      var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
      var container = $('#meal-container')
      container.html("")
      
//      for (var dayMealList of result.data.mealList) {
//        console.log(dayMealList)
//        var sortedMealLists = [];
//        for (var i = 0; i < 7; i++) {
//          if (dayMealList.day == ('day' + i)){
//            sortedMealLists[i] = dayMealList.day
//          } 
//          if(!result.data.mealList[i]) {
//            $('#meal-container').append("<div id='day" + i + "' class='tab-slider--body kcal-body'>" +
//                "<div class='kcal-info'><span class='total'>total</span><div class='kcal-total'>" +
//            "</div><span class='kcal'>kcal</span></div></div>")
//            for (var j = 0; j < 3; j++){
//              $('#day' + i).append("<div class='input-meal' onClick=inputMeal()>" +
//              "<center><div class='fa fa-camera camara-size'></div></center></div>")
//            }
//          }
//        }
//        console.log(sortedMealLists)
////        dayMeal.sortedMeals = sortedMeals;
//      }
      
      for (var i = 0; i < 7; i++) {
        if(!result.data.mealList[i]) {
          $('#meal-container').append("<div id='day" + i + "' class='tab-slider--body kcal-body'>" +
              "<div class='kcal-info'><span class='total'>total</span><div class='kcal-total'>" +
          "</div><span class='kcal'>kcal</span></div></div>")
          for (var j = 0; j < 3; j++){
            $('#day' + i).append("<div class='input-meal' onClick=inputMeal()>" +
            "<center><div class='fa fa-camera camara-size'></div></center></div>")
          }
        }
      }
      
//

      
      var html = container.html()
      container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.      })

      date(current)
      autoSelect(moment(current._i))


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

var months = ["January","February","March",
  "April","May","June","July",
  "August","September","October",
  "November","December"],
  current = moment(new Date());

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

function nextCalendar() {
  date(current.weekday(7))
  generateTemplate()
}
function prevCalendar() {
  date(current.weekday(-7))
  generateTemplate()
}

function inputMeal() {
  $('.input-food-container').toggle()
}

var delX;
var delY;
var phWid = parseInt($(".week-container").css("width"));
var shift;

function slideDate() {
  $(".week-container").on("touchstart", function(event) {
//  if (!event.pageX) event.preventDefault();
    var stX = event.pageX || event.originalEvent.touches[0].pageX;
    var stY = event.pageY || event.originalEvent.touches[0].pageY;
    $(".week-container").on("touchmove", function(event) {
      delX = (event.pageX || event.originalEvent.touches[0].pageX) - stX;
      delY = (event.pageY || event.originalEvent.touches[0].pageY) - stY;
    });
  });

  $(document).on("touchend", function() {
    if (delX > delY && delX > phWid / 2) {
      shift = "(" + phWid * 1.5 + "px, 0, 0)";
      prevCalendar();
    } else if (Math.abs(delX) > Math.abs(delY) && delX < -phWid / 2) {
      shift = "(" + (-phWid * 1.5) + "px, 0, 0)";
      nextCalendar();
    }
    delX = 0;
    delY = 0;

  });
}


//$('#calendar').datepicker({
//dayNames: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
//dayNamesMin: ["일", " 월", " 수", " 목", " 금", " 토", " 일"],
//format: "mm-yyyy",
//viewMode: "months",
//minViewMode: "months",
//showWeek: true,
//onSelect: function(dateText, inst) {
//var date = $(this).datepicker('getDate'),
//day  = date.getDate(),
//month = date.getMonth() + 1,
//year =  date.getFullYear();
//alert(day + '-' + month + '-' + year);
//}
//});
//$("#calendar").datepicker("setDate", new Date());
