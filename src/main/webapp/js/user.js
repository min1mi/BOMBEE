$("document").ready(function(){
  $(".tab-slider--body").hide();
  $(".tab-slider--body:first").show();

  date(current)
  moment().format();


  $(".tab-slider--nav .tab-slider--tabs div").click(function() {
    $(".tab-slider--body").hide();
    var activeTab = $(this).attr("rel");
    $("#"+activeTab).fadeIn();
  	if($(this).attr("rel") == "day1"){
  		$('.tab-slider--tabs').addClass('slide1');
  	}else if($(this).attr("rel") == "day2"){
  		$('.tab-slider--tabs').addClass('slide2');
  	}else if($(this).attr("rel") == "day3"){
  		$('.tab-slider--tabs').addClass('slide3');
  	}else if($(this).attr("rel") == "day4"){
  		$('.tab-slider--tabs').addClass('slide4');
  	}else if($(this).attr("rel") == "day5"){
  		$('.tab-slider--tabs').addClass('slide5');
  	}else if($(this).attr("rel") == "day6"){
  		$('.tab-slider--tabs').addClass('slide6');
  	}
  	else {
  		$('.tab-slider--tabs')
  			.removeClass('slide1 slide2 slide3 slide4 slide5 slide6');
  	}
    $(".tab-slider--nav .tab-slider--tabs div").removeClass("active");
    $(this).addClass("active");
  });

  // var swiper = new Swiper('.swiper-container', {
  //       loop: true
  //     }, swipeCalendar());
  //
  $('#btttn').on('click', function() {
    swipeCalendar()
  })

});

var months = ["January","February","March",
              "April","May","June","July",
              "August","September","October",
              "November","December"],
    current = moment(new Date());

function date(moment) { // get current date
 var sunDate = moment.clone(),
     month = months[current.get('month')];

  sunDate.add('days', -moment.weekday())
  console.log(sunDate.toDate());
  // var tempDate = moment(current)

  $('.year').html(current.get('year'));
  $('.month').html(month);

for (var i = 0; i < 7; i++) {
  $('.day' + i).html(sunDate.date())
  sunDate.add('days', 1)
}
}



function swipeCalendar() {
  date(current.weekday(7))
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
