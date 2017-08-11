// $(function() {
//   // $('.header').load('../menu/new.html')
//
//
var no;

$.getJSON('/auth/userinfo.json', function(result) {
	// console.log(result)
	no = result.data.no
  show();
  getData();
})



function show() {
  $('.body-time').hide();
  // $('.day').css('background-color', "orange")
  $('#time-mon').show();


}

$('.body-day div').click(function() {
        $('.day').css('background-color', "silver")
        $(this).css('background-color', "orange")
        switch ($(this).text()) {
          case "MON" :
           $('.body-time').hide()
           $('#time-mon').show()
          break;
          case "TUE" :
            $('.body-time').hide()
            $('#time-tue').show()
          break;
          case "WEB" :
            $('.body-time').hide()
            $('#time-web').show()
          break;
          case "THU" :
            $('.body-time').hide()
            $('#time-thu').show()
          break;
          case "FRI" :
            $('.body-time').hide()
            $('#time-fri').show()
          break;
          case "SAT" :
            $('.body-time').hide()
            $('#time-sat').show()
          break;
          case "SUN" :
            $('.body-time').hide()
            $('#time-sun').show()
          break;
          default:
         $('.body-time').attr('display: none')
        }

        // $(this).attr('id', "click")
})
var schedule = [];
$(".h-time").click(function() {
  console.log(this)
  if (($(this).attr("value")) == "off") {
    $(this).addClass('ok')
    $(this).attr("value","on")
    schedule.push($(this).attr('data-bookno'))
    console.log($(this).attr('data-bookno'))
    console.log(schedule)
  } else if (($(this).attr("value")) == "on") {
    $(this).removeClass('ok')
    $(this).attr("value","off")
    // schedule.pop()
    console.log(schedule)
    for (var i = 0; i < schedule.length; i++) {
      if (schedule[i] ==  $(this).attr('data-bookno')) {
        schedule.splice(i, 1)
        console.log(schedule)
      }
    }
  }
})

function getData() {
	$.getJSON('/schedule/detail.json', {no}, function(result) {
    console.log(result)
    console.log(no)

    if((result.data) != undefined) {
      var bookNo = result.data.weeklist[0].day+result.data.weeklist[0].time,
      weeklist = result.data.weeklist
      console.log(weeklist.length)
      for (var week of weeklist) {
        // console.log(week.day)
        // console.log(week.time)
        bookNo = week.day+week.time
        $('div[data-bookno=' + bookNo + ']').addClass('ok')
        $('div[data-bookno=' + bookNo + ']').attr('value', 'on')
        schedule.push(bookNo)
      }
    }
    else if ((result.data) == undefined) {

      console.log('인설트')
    }



	})
}

$("#save_Btn").on('click',function() {

  console.log("클릭클릭")
  console.log(schedule)

  for (var time of schedule) {
    // console.log(time)
    console.log(time.slice(0,3))
    console.log(time.slice(3,5))
    // $.post('/schedule/delete.json',{no}, function(result) {
    //
    // })
    $.post('/schedule/insert.json', {
      'tno': no,
      'day': time.slice(0,3),
      'time':time.slice(3,5)
  }, function(result) {
	  location.href = '/ekdma/tmdduf0.html'

	}, 'json')

  // console.log($)
  // var alist = $('.ok')
  //
  // console.log($(".ok[data-bookno]").attr("data-bookno"));
  // $.getJSON('/schedule/update.json', {no}, function(result) {


}
  // })
})
