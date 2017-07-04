//로그인 사용자 정보를 가져온다.
$.getJSON(contextRoot + '/auth/userinfo.json', function(result) {
  if (result.data) {
    $('#login').append($('<spen>').html(result.data.name + '(' + result.data.email + ')'))
               .append($('<a>').attr('id', 'logout-link').attr('href', '#').text('로그아웃'))
  
  }
	
//  var templateFn = Handlebars.compile($('#tbody-template').text())// 템플릿소스 문자열을 compile()안에 줘야함.
//  var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
//  tbody.text('') // tbody의 기존 tr 태그들을 지우고
//  tbody.html(generatedHTML) // 새 tr태그들로 설정한다. template가 리턴 하는 것이 html이라 text를 사용하면 안된다.
}) // getJSON()

$(document.body).on('click', '#logout-link', function(event) {
  $.getJSON(contextRoot + '/auth/logout.json', function(result) {
    location.href = contextRoot + '/auth/login.do'
  })
})















//
