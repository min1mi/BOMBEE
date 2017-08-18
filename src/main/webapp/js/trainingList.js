var json = '/auth/userinfo.json'
var no = 0
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
        getData('/management/trainingList.json', no)
      }else if(json == '/management/trainingList.json') {
        // 여기서 엘리먼트 생성하세요
      }
    })
  }
