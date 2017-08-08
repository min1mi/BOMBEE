	var no = 0; // 필터처리한걸로 no 값 받아와야함
  	var json = '/promotion/promotion.json'
  	var imgBtn = ''
  	var deleteBtn = $('.promotion-delete')
  	var deleteCan = 0 //1일때는 삭제할때다. //삭제버튼을 눌럿을때는 1이다.
  	var deleteNo = new Array()
  	var selectVal = $('#select-container')
  	var promotionAdd = $('#promotion-add')
  	$(function() {
  		deleteBtn.click(function() {
  			if (deleteCan == 0) {
  				deleteCan = 1
  				deleteBtn.addClass('background')
  			}else if (deleteCan == 1){
  				deleteCan = 0
  				deleteBtn.removeClass('background')
  				$('.list-pro').removeClass('border')
  				if(deleteNo.length > 0)
  				  ajax()
  			}
  		})
  		selectVal.change(function() {
  			$('.list-div').remove()
  			if ($('#select-container option:selected').val() == 0)
  				getData(json)
  			else
  				getData('/promotion/promotionTitle.json')
  			
  		})
  		promotionAdd.click (function() {
  			location.href = '../promotionAdd/promotionAdd2.html'
  		})
  	})
  $.getJSON('/auth/userinfo.json', function(result) {
	  console.log(result.data.membertype)
	  if(result.data.membertype == 1)
		  location.href = '../auth/login.html'
		else {
			no = result.data.no
			  if (no == 0)
			    console.log('응 로그인 실패')
			  else
			     getData(json)
		}
})
	function getData(json) {
		$.getJSON(json, {'no' : no}, function(result) {
		  	  console.log(result)
		      // 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
		      var templateFn = Handlebars.compile($('#list-template').text())
		      var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
		      var container = $('#list-container')
		      var html = container.html()
		      container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.
		      btnConect()
	})
  }
  	
  	function btnConect() {
  		imgBtn = $('.pro-img')
  		imgBtn.click(function() {
  			if (deleteCan != 0) {
  				if ($(this).attr('value') == 0) {
  					$(this).parent().parent().addClass('border')
  		      $(this).attr('value', 1)
  		      deleteNo.push($(this).prop('title'))
  		      console.log(deleteNo)
  				}else {
  					$(this).parent().parent().removeClass('border')
  		      $(this).attr('value', 0)
  		      deleteNo.splice(deleteNo.indexOf($(this).prop('title')), 1)
  		      console.log(deleteNo)
  				}
  			}
  			else {
  				//디테일 정보로 가는거 구현
  				location.href = '../promotionDetail/promotionDetail.html?no='+$(this).attr('title')
  			}
  		})
  	}
  	
  	
  	function ajax() {
  	  $.ajax({
  	    type: 'post' ,
  	    url: '/promotion/deletePromotions.json' ,
  	    data: {
  	    	"list":deleteNo
  	    	},
  	    dataType : 'json',
  	    success: function(result) {
  	    	console.log(result)
  	    	$('.list-div').remove()
  	    	getData(json)
  	     }
  	    })
  	}