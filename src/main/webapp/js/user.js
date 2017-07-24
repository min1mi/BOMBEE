$("document").ready(function(){
  $(".tab-slider--body").hide();
  $(".tab-slider--body:first").show();
});

$(".tab-slider--nav .tab-slider--tabs div").click(function() {
  $(".tab-slider--body").hide();
  var activeTab = $(this).attr("rel");
  $("#"+activeTab).fadeIn();
	if($(this).attr("rel") == "monday"){
		$('.tab-slider--tabs').addClass('slide1');
	}else if($(this).attr("rel") == "tuesday"){
		$('.tab-slider--tabs').addClass('slide2');
	}else if($(this).attr("rel") == "wednesday"){
		$('.tab-slider--tabs').addClass('slide3');
	}else if($(this).attr("rel") == "thursday"){
		$('.tab-slider--tabs').addClass('slide4');
	}else if($(this).attr("rel") == "friday"){
		$('.tab-slider--tabs').addClass('slide5');
	}else if($(this).attr("rel") == "saturday"){
		$('.tab-slider--tabs').addClass('slide6');
	}
	else {
		$('.tab-slider--tabs')
			.removeClass('slide1 slide2 slide3 slide4 slide5 slide6');
	}
  $(".tab-slider--nav .tab-slider--tabs div").removeClass("active");
  $(this).addClass("active");
});

date();

function date() {
  var current = new Date(), // get current date
      year = current.getFullYear(),
      months = ["January","February","March",
                "April","May","June","July",
                "August","September","October",
                "November","December"],
      month = months[current.getMonth()];
  var weekstart = current.getDate() - current.getDay() + 1;
  console.log(year, month);
  $('.year').html(year);
  $('.month').html(month);

  $('.sun').html(weekstart - 1);
  $('.mon').html(weekstart);
  $('.tue').html(weekstart + 2);
  $('.wed').html(weekstart + 3);
  $('.thu').html(weekstart + 4);
  $('.fri').html(weekstart + 5);
  $('.sat').html(weekstart + 6);
}

$('#calendar').datepicker({
  dayNames: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
  dayNamesMin: ["일", " 월", " 수", " 목", " 금", " 토", " 일"],
  format: "mm-yyyy",
  viewMode: "months",
  minViewMode: "months",
  showWeek: true,
  onSelect: function(dateText, inst) {
    var date = $(this).datepicker('getDate'),
        day  = date.getDate(),
        month = date.getMonth() + 1,
        year =  date.getFullYear();
    alert(day + '-' + month + '-' + year);
  }
});
$("#calendar").datepicker("setDate", new Date());
