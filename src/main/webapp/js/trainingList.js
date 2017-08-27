var json = '/auth/userinfo.json'
var no = 0
var mealBtn
var revBtn
var backscreen = $('.backscreen'),
reviewWriteCon = $('.review-write-container'),
pno = null,
protitle = null,
trano = null,
fiScore
  $(document).ready(function() {
    $('.header').load('../main/header.html')
    
    $('.reviewAdd').on('click', function() {
	    $.post('/review/add.json', {
	      'score' : fiScore,
	      'review': $('.review-text-container').val(),
	      'trano': trano,
	      'title':protitle,
	      'pno':pno
	    }, function(result) {
    	$.post('/review/boolean.json', {
    		'trano' : trano
    	},function(result) {
    	    location.reload()
    	    }, 'json')
    	}, 'json')
    })
    backscreen.on('click', function() {
    	backscreen.hide()
    	reviewWriteCon.hide()
    	reviewWriteCon.attr('data-open', 'close')
    	pno = null
    	protitle = null
    	trano = null
    })
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
  })
  getData(json, no)



  function getData(jsonType, no) {
    $.getJSON(jsonType,{
      no: no
    }, function(result) {
      console.log(result)
      if(json == '/auth/userinfo.json') {
        no = result.data.no
        json = '/management/trainingList.json'
        getData(json, no)
      }else if(json == '/management/trainingList.json') {
      	if(result.data.length == 0) 
		    $('.no-tcher').css('display', '')
		 else {
	    	  var templateFn = Handlebars.compile($('#training-template').text())
		      var generatedHTML = templateFn(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
		      var container = $('.training')
		      var html = container.html()
		      container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.
		      mealBtn()
		 }
      }
    })
  }
function mealBtn() {
	mealBtn = $('.mealBtn')
	mealBtn.click(function() {
		location.href = 'user.html?no='+$(this).attr('value')
	})
	revBtn = $('.revBtn')
	revBtn.click(function() {
	if (reviewWriteCon.attr('data-open') == 'close') {
		backscreen.show()
		reviewWriteCon.show()
		reviewWriteCon.attr('data-open', 'open')
	  }
	})
}
