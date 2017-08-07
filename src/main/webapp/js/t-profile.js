

// 우편번호 찾기 화면을 넣을 element
var element_layer = document.getElementById('layer');

function closeDaumPostcode() {
    // iframe을 넣은 element를 안보이게 한다.
    element_layer.style.display = 'none';
}

function sample2_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = data.address; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 기본 주소가 도로명 타입일때 조합한다.
            if(data.addressType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample2_postcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('sample2_address').value = fullAddr;

            // iframe을 넣은 element를 안보이게 한다.
            // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
            element_layer.style.display = 'none';
        },
        width : '100%',
        height : '100%',
        maxSuggestItems : 5
    }).embed(element_layer);

    // iframe을 넣은 element를 보이게 한다.
    element_layer.style.display = 'block';

    // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
    initLayerPosition();
}

// 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
// resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
// 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
function initLayerPosition(){
    var width = 100; //우편번호서비스가 들어갈 element의 width
    var height = 417; //우편번호서비스가 들어갈 element의 height
    var borderWidth = 2; //샘플에서 사용하는 border의 두께

    // 위에서 선언한 값들을 실제 element에 넣는다.
    element_layer.style.width = width + '%';
    element_layer.style.height = height + 'px';
    element_layer.style.border = borderWidth + 'px solid';
    // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
    element_layer.style.left = 0+'px';
    element_layer.style.top = 80 + 'px';
}
var fiSpono,
fiName,
fiComname,
fiZipcode,
fiComaddr,
fiComdetailaddr,
fiIntroduction,
no = -12
var spono



$('.pro-save-Btn').on('click', function() {
  console.log("클릭클릭")


  // spono.on('change', function() {

    // switch (spono){
    //   case "1" :
    //     fiSpono.val()= 1
    //   break;
    //   case "2" :
    //     fiSpono.val()= 2
    //   break;
    //   case "3" :
    //     fiSpono.val()= 3
    //   break;
    //   case "4" :
    //     fiSpono.val()= 4
    //   break;
    //   default :
    //     fiSpono.val()= null
  //
  // console.log(fiSpono.val());
  // console.log(spono.val());

    $.post('/trainer/update.json', {
      // 'spono': $('.spono').val(),
      // 'comname': $('.company_name').val(),
      // 'zipcode': $('.zip').val(),
      // 'comaddr': $('.address').val(),
      // 'comdetailaddr': $('.detail_address').val(),
      // 'introduction': $('.introduction').val(),
      // 'tno': $('.tno').val()
      'spono': spono,
      'comname':fiComname.val(),
      'zipcode': fiZipcode.val(),
      'comaddr': fiComaddr.val(),
      'comdetailaddr': fiComdetailaddr.val(),
      'introduction': fiIntroduction.val(),
      'tno': no
    }, function(result) {
      location.href = '../profile/t-profile.html'

    }, 'json')

})


$.getJSON('/auth/userinfo.json', function(result) {
	no = result.data.no
  getData()
})


function getData() {
  $.getJSON('/trainer/detail.json', {no}, function(result) {
    console.log(result.data.spono)
    // console.log($('#spono3'));
    // $('#spono3').attr('selected')
    var templateFn = Handlebars.compile($('#profile-template').text())
	  var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
	  var container = $('#profile-container')

	  var html = container.html()
    console.log($('#spono3'));
    // $('#spono3').attr('selected')
	  container.html(html + generatedHTML) // 새 tr 태그들로 설정한다.      })
    fiSpono = $('.spono')
    fiComname = $('.company_name')
    fiZipcode = $('.zip')
    fiComaddr = $('.address')
    fiComdetailaddr = $('.detail_address')
    fiIntroduction = $('.introduction')
    $('#pro-select').on('change',function() {
      spono = $('#pro-select option:selected').val()
      console.log(spono)
    })
    switch (result.data.spono){
      case "1" :
      console.log(1)
      $('#spono1').attr('selected', 'selected')
      break;
      case "2" :
      console.log(2)
      $('#spono2').attr('selected', 'selected')
      break;
      case "3" :
      console.log(3)
      $('#spono3').attr('selected', 'selected')
      break;
      case "4" :
      console.log("필라테스")
      $('#spono4').attr('selected', 'selected')
      break;
      default :
      console.log(5)
      $('#spono').attr('selected')
    }

  })
}


$('#fileupload').fileupload({
    dataType: 'json',
    add: function (e, data) {
      console.log('add()..')
      data.context = $('<button/>').text('Upload')
        .appendTo(document.body)
        .click(function () {
          data.context = $('<p/>').text('Uploading...').replaceAll($(this))
          data.submit();
        })
    },
    dataType: 'json',
    done: function (e, data) {
      console.log('done()...');
      console.log(data.result); // 서버가 보낸 JSON 객체는 data.result 에 보관되어 있다.
      var file = data.result.fileList[0];
      data.context.html("<img width'100' src='/upload/" + file.filename + "'> " + file.filesize)
    }

});
