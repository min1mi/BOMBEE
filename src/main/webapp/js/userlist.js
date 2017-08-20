var json = '/auth/userinfo.json'
  var no = 0
  var mealBtn
    $(document).ready(function() {
      $('.header').load('../menu/new.html')
    })
    getData(json, no)
    function getData(jsonType, no) {
      $.getJSON(jsonType,{
        no: no
      }, function(result) {
        console.log(result)
        if(json == '/auth/userinfo.json') {
          no = result.data.no
          json = '/management/usersList.json'
          getData(json, no)
        }else if(json == '/management/usersList.json') {
          var templateFn = Handlebars.compile($('#user-template').text())
          var generatedHTML = templateFn(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
          var container = $('.user')
          var html = container.html()
          container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.
          mealBtn()
        }
      })
    }
  function mealBtn() {
    mealBtn = $('.mealBtn')
    mealBtn.click(function() {
      location.href = 'trainer.html?no='+$(this).attr('value')
    })
  }
