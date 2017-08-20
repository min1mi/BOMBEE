$(function() {
	moment().format();
	$('.header').load('../menu/new.html')

	generateTemplate();
	date(current);
	dateClick();
	slideDate();

});
var trano = (location.href).split('=')[1]
var filenames = $('#filenames');

var today,
mealkcal = $('.food-kcal'),
mealname = $('.food-name'),
confirmmealname = $('.confirm-food-name'),
confirmmealkcal = $('.confirm-food-kcal'),
mealtype,
mealno;




$('#foodConfirmBtn').on('click', function() {
	$.post('/management/confirm.json', {
		'mealno' : mealno
		
	}, function(result) {
	  location.reload()
	}, 'json')
})

var startDate,
endDate, totalKcal = 0;



function generateTemplate() {

  $('.user').text(result.data.name)
	startDate = current.startOf('week').format("YYYY-MM-DD")
	endDate = current.endOf('week').format("YYYY-MM-DD")
	$.getJSON('usermeal-list.json', {"startDate": startDate,
		"endDate": endDate, "trainingNo": trano}, function(result) {
			var data = result.data
			// 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
			arrayData(data)
			console.log(result)
			console.log(data.mealList)
			var templateFn = Handlebars.compile($('#user-template').text())
			var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
			var container = $('#meal-container')
			container.html("")
			var html = container.html()
			container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.      })

			var templateFn1 = Handlebars.compile($('#meal-template').text())
			var generatedHTML1 = templateFn1(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
			var popcontainer = $('#pop-container')
			popcontainer.html("")
			var html1 = popcontainer.html()
			popcontainer.html(html1 + generatedHTML1)

			date(current)
			autoSelect(moment(current._i))
			inputMeal()
		})
}
function arrayData(data) {

	for (var i = 0; i < 7; i++){
		var sortedMealLists = [];
		for (var dayMealList of data.mealList) {
			switch (dayMealList.day) {
			case "day0":  sortedMealLists[0] = dayMealList; break;
			case "day1":  sortedMealLists[1] = dayMealList; break;
			case "day2":  sortedMealLists[2] = dayMealList; break;
			case "day3":  sortedMealLists[3] = dayMealList; break;
			case "day4":  sortedMealLists[4] = dayMealList; break;
			case "day5":  sortedMealLists[5] = dayMealList; break;
			case "day6":  sortedMealLists[6] = dayMealList; break;
			}
		}
		for (var j = 0; j < 7; j++) {
			if (!sortedMealLists[j]){
				sortedMealLists[j] = {day: 'day' + j, meal: []}
			}
			data.mealList = sortedMealLists
		}
	}

	for (var dayMeal of data.mealList) {
		var sortedMeals = [];
		for (var meal of dayMeal.meal) {
			switch (meal.mealtype) {
			case "breakfast": sortedMeals[0] = meal; break;
			case "lunch": sortedMeals[1] = meal; break;
			case "dinner": sortedMeals[2] = meal; break;
			}
		}

		for (var i = 0; i < 3; i++) {
			if (!sortedMeals[i]) {
				sortedMeals[i] = {index: i};
			}
		}
		dayMeal.sortedMeals = sortedMeals;
	}

	for (var i = 0; i < 7; i++) {
		for (var j = 0; j < 3; j++) {
			if(data.mealList[i].meal[j] == undefined)
				continue;
			totalKcal += parseInt(data.mealList[i].meal[j].mealkcal)
		}
		data.mealList[i].totalKcal = totalKcal
		totalKcal = 0;
//		$('#day' + i).children().children('.kcal-total').text(totalKcal)
	}
}
function dateClick() {
	var tabClick = $(".tab-slider--nav .tab-slider--tabs div")
	tabClick.click(function() {
		$(".tab-slider--body").hide();
		var activeTab = $(this).attr("rel");
		$("#"+activeTab).fadeIn();
		if(activeTab == "day0"){
			sliderDate(0)
		} else if(activeTab == "day1"){
			sliderDate(1)
		} else if(activeTab == "day2"){
			sliderDate(2)
		} else if(activeTab == "day3"){
			sliderDate(3)
		} else if(activeTab == "day4"){
			sliderDate(4)
		} else if(activeTab == "day5"){
			sliderDate(5)
		} else if(activeTab == "day6"){
			sliderDate(6)
		} else {
			$('.tab-slider--tabs')
			.removeClass('slide0 slide1 slide2 slide3 slide4 slide5 slide6');
		}
		tabClick.removeClass("active");
		$(this).addClass("active");
	});

	console.log('dateClick()')
}
function sliderDate(no) {
	$('.tab-slider--tabs').addClass('slide' + no);
}

var months = ["January","February","March",
	"April","May","June","July",
	"August","September","October",
	"November","December"],
	current = moment(new Date());

function autoSelect(moment) {
	var dayNo = moment.weekday()
	$('.tab-slider--tabs').removeClass('slide0 slide1 slide2 slide3 slide4 slide5 slide6');
	$(".tab-slider--body").hide();
	selectDate(dayNo)
}

function selectDate(no) {
	$('.tab-slider--tabs').addClass('slide' + no);
	$('.day'+no).addClass("active");
	$("#day"+no).show();
	if ($('.day' + no).text() == moment(new Date()).format("D")) {
		$('#day' + no).children('.input-meal').addClass("add")
		$('#day' + no).children('.meal').addClass("update")
	}
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

var confirmmeal = $('.confirm-meal'),
backscreen = $('.backscreen');

function inputMeal() {
	$('.update').on('click', function() {
		today = $(this).parent().attr('id')
		mealtype = $(this).children('.meal-type').text()
		mealno = $(this).attr('value')

		$("<img>").attr('src', $(this).children('.img-fix').children().attr('src')).addClass("img-size").appendTo($('#updatefiles'));
		$('.comfirm-food-name').val($(this).children('.meal-name').text())
		$('.confirm-food-kcal').val($(this).children('.meal-kcal').attr('value'))
    
		if(confirmmeal.attr('data-open') == 'close') {
			backscreen.show()
			confirmmeal.show()
			confirmmeal.attr('data-open', 'open')
		}
	})
	
	backscreen.on('click', function() {
		backscreen.hide()
		confirmmeal.hide()
		confirmmeal.attr('data-open', 'close')
	})
}


var delX;
var delY;
var phWid = parseInt($(".week-container").css("width"));
var shift;

function slideDate() {
	$(".week-container").on("touchstart", function(event) {
//		if (!event.pageX) event.preventDefault();
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
