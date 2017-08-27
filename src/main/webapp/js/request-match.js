$(function() {
  $('.header').load('../main/header.html')
})


var json = '/auth/userinfo.json'
  var no = -1
  var trano = -1
  getData(json, no)
var sdt =-1
var period = -1
function getData(json, no) {
  $.getJSON(json, {
    'no' : no,
    'sdt':sdt,
    'period':period
  }, function(result) {
    if (json == '/auth/userinfo.json') {
      if (result.data.membertype == 1)
        no = result.data.no
        else
          location.href = '../auth/login.html'
            console.log(no)
            getData('/friend/addMlist.json', no)
    } else if (json == '/friend/addMlist.json') {
      console.log(result)

      for(var i = 0; i < result.data.length; i++) {
        if (result.data[i].tPic == undefined) {
          result.data[i].tPic = null
        }
      }
      console.log(result)
      var templateFn = Handlebars.compile($('#request-template').text())
      console.log(result.data)
      var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
      var container = $('.request-container')
      container.html("")
      container.html(generatedHTML)

      if(result.data == 0)
        $('.no-alram').css('display', '')
        
      btnConnect()
    } else if (json == '/friend/friendDelete.json') {
      console.log(result)
      location.reload()
    }
  })
}
function btnConnect() {
  $('.cancle').click(function() {
    trano = $(this).attr('data-trano')
    console.log(trano)
    getData('/friend/friendDelete.json', trano)
  })
  console.log(trano)
} 