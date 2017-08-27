
var json = '/promotion/hot-firstList.json'
  var category;
var count = 0
var lastNo = 1000
var offset = 0
var no = 0
var type = $('.click').children().attr('value')
var titleImage = []
var imgTag = []
var width = 0
if($(window)[0].innerWidth > 375 && $(window)[0].innerWidth <= 414) 
  width = '_210.png'
    else if($(window)[0].innerWidth > 320 && $(window)[0].innerWidth <= 375) 
      width = '_190.png'
        else if($(window)[0].innerWidth <= 320)
          width = '_170.png'
            console.log(width)
            var swiper = new Swiper('.swiper-container', {
              loop: true,
              autoplay: 2000,
              autoplayDisableOnInteraction: false
            });
$(document).ready(function() {
  $(window).scroll(function () {
    if($(window).scrollTop() == $(document).height() - $(window).height()) {
      lastNo = $('#last-promotion').attr('value') -1
      $('#last-promotion').attr('id', '')
      json = '/promotion/hot-nextList.json';
      console.log(type)
      console.log(lastNo)
      if(type != 0)
        json = '/promotion/health-nextList.json'
          getData(json, type) 
    }
  })

})

$('.btn').click(()=> {
  $('.btn').css('color', 'black');
  $('.btn-test').css('color', 'white')
})

Handlebars.registerHelper('isIndex', function(index, promotion ,options) {
  imgTag.push('img-'+promotion.pno)
  titleImage.push(promotion.titlePic)
  if (index % 2 == 0) {
    console.log(options.fn(this))
    return options.fn(this);
  } else {
    return options.inverse(this);
  }
});


getData(json, 0);

function getData(json, typeNo) {
  if ( json == '/promotion/hot-nextList.json' || 
      json == '/promotion/health-nextList.json') {

    console.log(lastNo)
  }
  else 
    $('.promotion').remove()
    if (lastNo > 1) {
      $.getJSON(json, {
        'lastNo' : lastNo,
        'typeNo': typeNo
      }, function(result) {
        console.log(result.data)
        // 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
        var templateFn = Handlebars.compile($('#health-template').text())
        var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
        var container = $('#promotion-in')
        var html = container.html()
        container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.
        console.log(imgTag)
        console.log(titleImage)
        btnClick()
        for (var i = 0; i < imgTag.length; i++) {
          $('.'+imgTag[i]).attr('src', '../upload/'+titleImage[i]+width)
          console.log(imgTag[i])
          console.log(titleImage[i])
        }
        imgTag= []
        titleImage = []
      })
    }
  lastNo = 100
}

function borderBottom(category) {
  $('.btn').removeClass('click')
  $(category).parent().addClass('click')
  type = $('.click').children().prop('value')

}
$('#searchMapGo').click(function () {
  location.href = '../list/searchList.html'
})

$('#hot-cos').click(() => {
  category = '#hot-cos'
    borderBottom(category)
    json = '/promotion/hot-firstList.json'
      getData(json, 0)
})

$('#pilates').click(() => {
  category = '#pilates'
    borderBottom(category)
    json = '/promotion/health-firstList.json'
      getData(json, 4)

})

$('#yoga').click(() => {
  category = '#yoga'
    borderBottom(category)
    json = '/promotion/health-firstList.json'
      getData(json, 3)
})

$('#health').click(() => {
  category = '#health'
    borderBottom(category)
    json = '/promotion/health-firstList.json'
      getData(json, 1)

})
$('#spinning').click(() => {
  category = '#spinning'
    borderBottom(category)
    json = '/promotion/health-firstList.json'
      getData(json, 2)
})
function btnClick() {
  $('.go-detail').click(function() {

    no = $(this).children().children().attr('value')
    location.href = '../promotion/promotionDetail.html?no='+no
    //no='+no
    //$.getJSON()
  })
}
