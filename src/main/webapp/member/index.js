 // 이렇게 변수 선언을 해두면 호출될 때마다 DOM Tree를 뒤질 필요가 없어서
 // 성능적으로 낫다.
var pageNoTag = $('#page-no'),
    tbody = $('#student-tbl > tbody'),
    prevBtn = $('#prev-btn'),
    nextBtn = $('#next-btn'),
    lstBtn = $('#lst-btn'),
    pageSize = 5;
var currPageNo = parseInt(pageNoTag.text())

$(document.body).on('click', '.detail-link', (function(event) {
  location.href='view.html?no=' + $(this).attr('data-no')
  event.preventDefault()
}))

prevBtn.click(function() {
  displayList(currPageNo - 1)
})

nextBtn.click(function() {
  displayList(currPageNo + 1)
})

lstBtn.click(function() {
  location.href="/"
})

function displayList(pageNo) {
  // 서버에서 학생 목록 데이터를 받아 온다.
  $.getJSON('list.json', {pageNo: pageNo, pageSize: pageSize}, function(result) {
    var totalCount = result.data.totalCount,
        lastPageNo = parseInt(totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0);

    // 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
    var templateFn = Handlebars.compile($('#tbody-template').text())// 템플릿소스 문자열을 compile()안에 줘야함.
    var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
    tbody.text('') // tbody의 기존 tr 태그들을 지우고
    tbody.html(generatedHTML) // 새 tr태그들로 설정한다. template가 리턴 하는 것이 html이라 text를 사용하면 안된다.

    currPageNo = pageNo
    pageNoTag.text(currPageNo) // currPageNo 를 출력

    if (currPageNo == 1) {
      prevBtn.prop('disabled', true)
    } else {
      prevBtn.prop('disabled', false)
    }

    if (currPageNo == lastPageNo) {
      nextBtn.prop('disabled', true)
    } else {
      nextBtn.prop('disabled', false)
    }
  }) // getJSON()
  // 아래의 것들이 쓰기 귀찮아서 나온 함수가 getJSON()
  // }, 'json') // 형식이 json이니까 알아서 파싱해서 넘겨줘
  // }) // 서버에서 json 을 넘겨준다고 content-type을 지정해 준다면 json을 적어주지 않아도 된다.
} // displayList()

displayList(1)

















//
