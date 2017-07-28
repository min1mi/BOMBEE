
$(function() {
  $('.main-box').css({'background-image': 'url(' + '../image/L-Image/' + images[Math.floor(Math.random() * images.length)] + ')'});

  $('#user').click(function() {
    joinType = $(this).val()
    borderBottom('#user')
    $('.main-box').css('background-image','url(' + '../image/L-Image/' + images[Math.floor(Math.random() * images.length)] + ')')
    $('.trainer-join').css('display', 'none')
  })

  $('#trainer').click(function() {
    joinType = $(this).val()
    borderBottom('#trainer')
    $('.main-box').css('background-image', 'url(../image/join-tall.jpg)');
    $('.trainer-join').css('display', '')
  })
})

var images = ['l-t01.jpg', 'l-t02.jpg', 'l-t03.jpg', 'l-t04.jpg', 'l-t05.jpg',
  'l-t06.jpg', 'l-t07.jpg', 'l-t08.jpg', 'l-t09.jpg', 'l-t10.jpg', 'l-t11.jpg'];

var joinType = 1;
var fiId = $('.id'),
fiEmail = $('.email'),
fiName = $('.user'),
fiPassword = $('.pass'),
fiComname = $('.company_name'),
fiZipcode = $('.zip'),
fiComaddr = $('.address'),
fiComdetailaddr = $('.detail_address')


$('#add-btn').on('click', function() {
  console.log(joinType)
  if(joinType == 1) {
    $.post('/member/add.json', {
      'id' : fiId.val(),
      'email': fiEmail.val(),
      'name': fiName.val(),
      'pwd': fiPassword.val(),
      'membertype': joinType
      
    }, function(result) {
      location.href = '../main/main.html'
        
    }, 'json')
  } else if(joinType == 2) {
    $.post('/trainer/add.json', {
      'id' : fiId.val(),
      'email': fiEmail.val(),
      'name': fiName.val(),
      'pwd': fiPassword.val(),
      'comname': fiComname.val(),
      'zipcode': fiZipcode.val(),
      'comaddr': fiComaddr.val(),
      'comdetailaddr': fiComdetailaddr.val(),
      'membertype': joinType
      
    }, function(result) {
      console.log(result)
      location.href = '../main/main.html'
        
    }, 'json')
  }

})


//우편번호 찾기 화면을 넣을 element
var path = document.getElementById('main-boxs');
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

//브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
//resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
//직접 element_layer의 top,left값을 수정해 주시면 됩니다.
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



function borderBottom(category) {
  $('.btn').removeClass('click')
  $(category).parent().addClass('click')
}
