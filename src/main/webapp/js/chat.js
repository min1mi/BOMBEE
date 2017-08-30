var no = -1
var tno = -1
var yourName
var yourNo
var chatLine
var myNo
var membertype
var type = 0
var length = 0
/* var server = location.host + '/upload/' */
var server = 'http://'+location.host
console.log(server)

$('.close-btn').on('click', function(){
  window.history.go(-1)
})

chatLoad()

setInterval (chatLoad, 1000)


function chatLoad() {
	$.getJSON('/auth/userinfo.json', function(result) {
		  console.log(result.data.name)
		  if (result.status != 'fail'){
		    membertype = result.data.membertype
		    if(result.data.membertype == 1) {
		      no = result.data.no
		      myNo = no
		    }
		    if(result.data.membertype == 2) {
		      tno = result.data.no
		      myNo = tno
		    }

		    console.log(no)
		    console.log(tno)
		    if (tno != -1)
		      getChat(tno, '/chat/trainerList.json')
		      else if (no != -1)
		        getChat(no, '/chat/memberList.json')
		  }
		  /*  else if(result.status == 'fail')
		     location.href='../auth/login.html'  */
		})
}

function getChat(no, json) {
  $.getJSON(json, {no}, function(result) {
	var empty = $('.chat-content').children().first()
    for(var i = 0; i < result.data.length; i++) {
    	empty.addClass(''+i)
    	empty = empty.next()
    }
	for(var i = 0; i < result.data.length; i++) {
		$('.'+i + ' dd').text('')
		$('.'+i + ' dd').text(result.data[i].message)
	}
	if(length > result.data.length) {
		for(var i = length-1; i > result.data.length-1; i--) {
			$('.'+i).remove()
		}
	}else if (length < result.data.length) {
		length = result.data.length
		for(;length < result.data.length; length++) {
			$('div').addClass('chat-line').addClass('length')
		}
	}

    if(no != -1) {
      for(var i = 0; i < result.data.length; i++) {
        if(undefined == result.data[i].mPath)
          result.data[i].mPath = null
      }
      console.log(result.data)
    }
    yourName = result.data.you
    // 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
    if(type == 0 && result.data.length != 0) {
    	length = result.data.length
    	var templateFn = Handlebars.compile($('#chat-template').text())
        var generatedHTML = templateFn(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
        var container = $('#chat-container')
        var html = container.html()
        container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.
        chatDetailBtn()
        
        type = 1
    }
    if(result.data == 0) 
      $('.no-alram').css('display', '')
      
    $.each(result.data, function(i, item) {
      console.log(item.unread)
      
    })
  })
}


Handlebars.registerHelper('youAndMe', function(chatInfo ,options) {
  console.log(chatInfo)

  if (no == -1) {
    console.log('강사로그인')
    if (tno == chatInfo.trainerno){
      yourNo = chatInfo.memberno
      return options.fn(this);
    }
  }else if (tno == -1) {
    console.log('멤버로그인')
    if (no == chatInfo.memberno) {
      yourNo = chatInfo.trainerno
    }
  }

  return options.inverse(this);
});

Handlebars.registerHelper('chat-confirm', function(unread ,options) {
  console.log(unread)
    if (unread > 0){
      return options.fn(this);
    } else {
      return options.inverse(this);
    }
});

console.log(location.host)
function chatDetailBtn() {
  chatLine = $('.chat-line')
  chatLine.click(function () {
	  yourNo = $(this).children('dl').children().first().attr('value')
	  console.log(myNo)
	  console.log(yourNo)
	  $.getJSON('/chat/updateRead.json', {
		  'membertype':membertype,
		  'mymno':myNo,
		  'yourmno':yourNo
	  },function(result) {
		  console.log("성공")
	  })
    var img = '/'+ $(this).children('div').children('img').attr('src').split('/')[1] +'/'+
    $(this).children('div').children('img').attr('src').split('/')[2]
    location.href = 'http://' + location.host + ':8888/detail-chat.html?myNo=' + myNo + '&yourNo='
    + $(this).children('dl').children().first().attr('value')+'&yourName='
    +$(this).children('dl').children().first().text()+'&membertype='+membertype +
    '&imagePath='+ server+img;
  })
}
