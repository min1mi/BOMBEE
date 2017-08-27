$(function() {
  $('.header').load('../main/header.html')
})
var json = '/auth/userinfo.json'
var no = -1
var trano = -1
getData(json, no)
var sdt =-1
var period = -1
var othername = -1
var mymno = -1
var othermno = -1
var count = -1
console.log("서버주소="+ location.host)
function getData(json, no) {
	console.log(no)
  $.getJSON(json, {
    'no' : no,
    'sdt':sdt,
    'period':period
  }, function(result) {
    if (json == '/auth/userinfo.json') {
      if (result.data.membertype == 2) {
        no = result.data.no
        othermno = result.data.no
        othername = result.data.name
      }else
        location.href = '../auth/login.html'
      console.log()
      getData('/friend/addList.json', no)
    } else if (json == '/friend/addList.json') {
      console.log(result)
      var templateFn = Handlebars.compile($('#requested-template').text())
      var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
      var container = $('.requested-container')
      container.html("")
      container.html(generatedHTML)

      if(result.data == 0)
        $('.no-alram').css('display', '')
        
      btnConnect()
    } else if (json == '/friend/friendDelete.json') {
      console.log(result)
      if(othername != -1 && mymno != -1 && othermno != -1) {
    	  ajaxNode(1, othername, mymno, "친구거절")
      }
    } else if (json == '/friend/friendUpdate.json') {
      // 수락 버튼을 눌렀을 때 실행하면 되는데 sdt를 오늘 날짜로 다시 update해줘야함
      // mno 도 날려야함 no는 tno
    	console.log(result)
    	if(othername != -1 && mymno != -1 &&	 othermno != -1)
      	  ajaxNode(1, othername, mymno, "친구수락")
    }
  })
}
function btnConnect() {
  $('.refuse').click(function() {
	count = 1
    trano = $(this).attr('data-trano')
    mymno = $(this).attr('data-mno')
    swal({
    	  title: "Are you sure?",
    	  text: "Refuse friend request will you do it?",
    	  type: "warning",
    	  showCancelButton: true,
    	  confirmButtonColor: "#DD6B55",
    	  confirmButtonText: "Yes, delete it!",
    	  cancelButtonText: "No, cancel plx!",
    	  closeOnConfirm: false,
    	  closeOnCancel: false
    	},
    	function(isConfirm){
    		sweetTabindex()
    	  if (isConfirm) {
    		getData('/friend/friendDelete.json', trano)
    	    swal("Deleted!", "Successfully deleted.", "success");
    	  } else {
    	    swal("Cancelled", "Request canceled :)", "error");
    	  }
    	});
  })
  $('.accept').click(function() {
    trano = $(this).attr('data-trano')
    mymno = $(this).attr('data-mno')
    period=$(this).parent().parent().children('.requested-info').children('.wish-period').attr('value')
    sdt = $(this).parent().parent().children('.requested-info').children('.wish-date').attr('value')
    if(period != -1 || sdt != -1)
      getData('/friend/friendUpdate.json', trano)
    else
      console.log('잘못됨')
  })
  console.log(trano)
}
function ajaxNode(no, othername, mymno, kinds){
	$.ajax({
		url: 'http://'+ location.host +':8888/alert/add.json',
		type: 'post',
		data:{
			type: no,
			othername: othername,
			mymno: mymno,
			othermno: othermno,
			kinds: kinds
			},
		dataType:'json',
		success: function(result) {
			othername = -1
			mymno = -1
			othermno = -1
			console.log(result)
			if(count != -1) 
				count = 1
			location.reload()
		}
	})
}
function sweetTabindex() {
	$('.confirm').click(function() {
		location.reload()
	})
}