var  mno
var no
var tno
var mname
var mymno = -1
var tname
var tpic
var realpic
var membertype
var fiScore = "";

var fiReview = $('.comment_area'),
fiTrano = "";

$(document).ready(function(){
	  
	  /* 1. Visualizing things on Hover - See next part for action on click */
	  $('#stars li').on('mouseover', function(){
	    var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on
	   
	    // Now highlight all the stars that's not after the current hovered star
	    $(this).parent().children('li.star').each(function(e){
	      if (e < onStar) {
	        $(this).addClass('hover');
	      }
	      else {
	        $(this).removeClass('hover');
	      }
	    });
	    
	  }).on('mouseout', function(){
	    $(this).parent().children('li.star').each(function(e){
	      $(this).removeClass('hover');
	    });
	  });
	  
	  
	  /* 2. Action to perform on click */
	  $('#stars li').on('click', function(){
	    var onStar = parseInt($(this).data('value'), 10); // The star currently selected
	    var stars = $(this).parent().children('li.star');
	    
	    for (i = 0; i < stars.length; i++) {
	      $(stars[i]).removeClass('selected');
	    }
	    
	    for (i = 0; i < onStar; i++) {
	      $(stars[i]).addClass('selected');
	    }
	    
	    // JUST RESPONSE (Not needed)
	    fiScore = parseInt($('#stars li.selected').last().data('value'), 10);
	    
	    return fiScore;
	    
	  });
	  
	  
	});

$('.re-add-Btn').on('click', function() {
	console.log("fiscore 밑밑밑")
	console.log(fiScore)
	console.log("fire")
	console.log(fiReview.val())
	console.log(fiTrano)
    $.post('/review/add.json', {
      'score' : fiScore,
      'review': fiReview.val(),
      'trano': fiTrano
    }, function(result) {
    	console.log("골칫거리")
    	console.log(fiTrano)
    	$.post('/review/boolean.json', {
    		'trano' : fiTrano
    	},function(result) {
    	    	console.log("리뷰상태변경완료")
    	    }, 'json')
    }, 'json')
  
})

//로그인정보 담는 유저인포
$.getJSON('/auth/userinfo.json', function(result) {
	mno = result.data.no
	mymno = result.data.no
	mname = result.data.name
	membertype = result.data.membertype
	// no = 0
	try {
			no = location.href.split('?')[1].split('=')[1]
	} catch (err) {
		console.log(no)

	}
  generateTemplate();
	generateTemplate2('/promotion/promotionTitle.json');
	generateTemplate3()
	getCalData(no);
// getData1('/promotion/promotionTitle.json');
})


//강사정보 뿌려주는 핸들바스탬플릿
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
		// setTimeout("detail2();", 1000);
		f_like();
		f_btn();
		return tno, tname;
  })
}


//프로모션 뿌려주는 핸들바스탬플릿
function generateTemplate2(json) {
	$.getJSON(json, {'no' : no}, function(result) {
				// console.log(result.data.list)
				// 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
				var templateFn = Handlebars.compile($('#list-template').text())
				var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
				var container = $('.sl')
				var html = container.html()
				container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.
				btnConect()
			})
}
function generateTemplate3() {
	console.log("리뷰 nononono=" + no)
	$.getJSON('/review/detail2.json', {no}, function(result) {
		console.log("승열11")
				 console.log(result)
				console.log("승열22")
				// 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
				var templateFn = Handlebars.compile($('#review-template').text())
				var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
				var container = $('.r-r-inner')
				var html = container.html()
				container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.
				if($('#'+mymno))
					$('#'+mymno).css('display', '')
				reviewBtn()
			})
}

//좋아요 버튼
function f_like(){
	$.post('/friend/detail2.json', {
		'mno':mno,
		'tno':tno
	}, function(result) {
		if(result.status=="success"){
			
		}
	})
}

//친구버튼
function f_btn(){
	$.post('/friend/detail.json', {
		'mno':mno,
		'tno':tno
	}, function(result) {
		if(result.status=="success"){
			
		}
	})
}



//스케줄에 표시
function getCalData(no) {
	console.log("윤민이")
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


//토글로 시간표
jQuery(document).ready(function($){

$(".pro-t-Btn").click(function(){
	$(".r-r-table").hide();
	$(".t-review").hide();
	$(".t-t-table").show();

});
$(".pro-r-Btn").click(function(){
	$(".t-t-table").hide();
	$(".t-review").hide();
	$(".r-r-table").show();
});

// 리뷰작성 버튼
$(".pro-rc-Btn").click(function(){
	$.getJSON('/friend/detail3.json', {
		'mno':mno,
		'tno':tno
		}, function(result) {
			console.log(tno)
			console.log(mno)
			console.log(result)
			if (result.status == "fail") {
				alert("친구신청하세요")//트레이닝중이아니다
			}else if (result.data.writerev ==true) {
				alert("한번에 한번이야")//이미 작성했다
			}else if (result.data.writerev == false){
				$(".t-t-table").hide();
				$(".r-r-table").hide();
				$(".t-review").show();
			}
			console.log(mno)
			console.log(tno)
			console.log(result.data.trano)
			fiTrano = result.data.trano
			return fiTrano
	})
});
})

$('.pro-chat-Btn').on('click', function() {
	console.log(mno + " : 회원번호")
	console.log(tno + " : 강사번호")
	console.log(mname + " : 회원이름")
	console.log(tname + " : 강사이름")
	console.log(location.host + tpic)

	realpic = location.host + tpic
	location.href = 'http://'+location.host+':8888/detail-chat.html?myNo=' + mno + '&yourNo='
			+ tno +'&yourName='
			+ tname +'&membertype='
			+ tname +'&imagePath='+ realpic;
})

//친구버튼 눌렀을떄
$('.pro-fa-Btn').on('click', function() {
	if (mno == tno) {
		alert("나야나")
	}else if (membertype == 2) {
			alert("강사끼리안되")
	
	// }	else if {
	// 	 alert(<h1>이럴수도있어
	// 		 <h1/>)
	// }
} else {
			console.log("친구추가 완료")
	} 


})
//좋아요 눌렀을떄
$('.likeBtn').click(function() {
	if (mno == tno) {
		alert("나야나")

	}else if (membertype == 2) {
			alert("강사끼리안되")

	}else {
			$.getJSON('/friend/add2.json', {
				'mno': mno,
				'tno': tno,
				}, function(result) {
					console.log(result)
					console.log(tno)
					console.log(mno)
					console.log("좋음 완료")
			})
	}
})
function btnConect() {
	imgBtn = $('.pro-pic')
	imgBtn.click(function() { // 이미지클릭하면 화면넘어가는 거 처리
			location.href = '../promotionDetail/promotionDetail.html?no='+$(this).attr('value')
	})
}

function reviewBtn() {
	$('.rev-delete').click(function() {
		reviewJson('/review/delete.json', $(this).attr('data-review'))
	})
//	$('.rev-modify').click(function() {
//		reviewJson('/review/reviewUpdate.json', $(this).attr('data-review'))
//	})
}
function reviewJson(json, reviewno) {
	$.getJSON(json, {
		'no':reviewno
	}, function(result) {
		location.reload()
	})
}