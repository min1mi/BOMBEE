var  mno
var no
var tno
var boool
var mname

var tname
var tpic
var realpic
var islike

$.getJSON('/auth/userinfo.json', function(result) {
	console.log(result)
	mno = result.data.no
	mname = result.data.name
	console.log(result.data.name)
	console.log(result.data.no)
	// no = 0
	try {
			no = location.href.split('?')[1].split('=')[1]
	} catch (err) {
		console.log(no)

	}
  generateTemplate();
	generateTemplate2();
	getData();

})
function generateTemplate() {
  $.getJSON('/trainer/detail.json', {no}, function(result) {
    var templateFn = Handlebars.compile($('#detail-template').text())
    var generatedHTML = templateFn(result.data)
    var container = $('#detail-container')
    var html = container.html()
    container.html(html + generatedHTML)
    // console.log(result)
		tno = result.data.no
		tname = result.data.name
		tpic = result.data.tcherpic
    switch (result.data.spono){
      case "1" :
      $('.t-spono').text('요가')
      break;
      case "2" :
      $('.t-spono').text('헬스')
      break;
      case "3" :
      $('.t-spono').text('스피닝')
      break;
      case "4" :
      $('.t-spono').text('필라테스')
      break;
      default :
      console.log("선택하세요")
    }
		return tno, tname;
  })
}

function generateTemplate2() {
  $.getJSON('/friend/detail2.json', {mno, tno}, function(result) {
    console.log("값가져옴")
		console.log(mno)
		console.log(tno)
		console.log(result)
    }
  )}



function getData() {
	$.getJSON('/schedule/detail.json', {no}, function(result) {
		console.log(result.data.weeklist.day+result.data.weeklist.time)

		var bookNo = result.data.weeklist.day+result.data.weeklist.time,
				weeklist = result.data.weeklist
				console.log(weeklist.length)
		for (var week of weeklist) {
			bookNo = week.day+week.time
			$('td[data-bookno=' + bookNo + ']').addClass('ok')
		}


	})
}
function getLike() {
	console.log(tno,"트레이너 넘")
	console.log(mno,"member 넘")
	$.getJSON('/friend/detail.json', {'tmno' : mno, 'tno': tno}, function(result) {
		console.log(result, "요기")
			// islike =



	})
}
function getAdd() {
	$.getJSON('/friend/detail.json', {'mno' : mno, 'tno': tno}, function(result) {
		console.log(result)
			// islike =
	$.getJSON('/friend/detail.json', {no}, function(result) {
		console.log(result.data.weeklist.day+result.data.weeklist.time)


			$('i[data-likeno=' + likeno + ']').addClass('fa-star-o')



	})
})}

jQuery(document).ready(function($){

$(".pro-t-Btn").click(function(){
$(".t-t-table").slideToggle(400);
});
})

$('.pro-add-Btn').on('click', function() {
	boool = false;
	console.log(mno + " : 회원번호")
	console.log(tno + " : 강사번호")
	console.log(boool + " : 참거짓")
	console.log(mname + " : 회원이름")
	console.log(tname + " : 강사이름")
	console.log(location.host + tpic)

	realpic = location.host + tpic
	location.href = 'http://192.168.0.71:8888/detail-chat.html?myNo=' + mno + '&yourNo='
			+ tno +'&yourName='
			+ mname +'&membertype='
			+ tname +'&imagePath='+ realpic;
	// console.log("C:\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp3\wtpwebapps\BOMBEE\image" + tpic)
	// console.log(status.data.name)
	// console.log(status.data.name)
	// $.getJSON('/friend/chatadd.json', {
	// 	'mno':mno,
	// 	'tno': tno,
	// 	'confirm': boool
	// 	}, function(result) {
	//
	// })
})
// $('.pro-add-Btn').on('click', function() {
// 	boool = false;
// 	console.log(mno)
// 	console.log(tno)
// 	console.log(boool)
// 	// console.log(status.data.name)
// 	// console.log(status.data.name)
// 	if ()
// 	$.getJSON('/friend/add.json', {
// 		'mno':mno,
// 		'tno': tno,
// 		'confirm': boool
// 		}, function(result) {
//
// 	})
// })

$('.pro-fa-Btn').on('click', function() {
	if (($(this).attr("value") == "off")) {
			boool = false;
			$(this).attr("value","on")
			$(this).attr("src","addd.png")
			$.getJSON('/friend/add.json', {
				'mno':mno,
				'tno': tno,
				'confirm': boool
				}, function(result) {
					console.log("친구추가 완료")
			})
	} else if (($(this).attr("value") == "on")){
			$(this).attr("value","off")
			$(this).attr("src","F_add.png")
			$.getJSON('/friend/delete.json', {
				'mno':mno,
				'tno': tno
			}, function(result) {
				console.log("친구삭제 완료")
			})
	}
})

$('.likeBtn').click(function() {
	if (($(this).attr("value") == "off")) {
			boool = false;
			$(this).attr("value","on")
			$(this).removeClass("fa-star-o")
			$(this).addClass("fa-star")
			$.getJSON('/friend/add2.json', {
				'mno': mno,
				'tno': tno,
				}, function(result) {
					console.log(result)
					console.log(tno)
					console.log(mno)
					console.log("좋음 완료")
			})
	} else if (($(this).attr("value") == "on")){
			$(this).attr("value","off")
			$(this).addClass("fa-star-o")
			$(this).removeClass("fa-star")
			$.getJSON('/friend/delete2.json', {
				'mno':mno,
				'tno': tno
			}, function(result) {
				console.log("취소 완료")
			})
	}
})
