var management = $('#header-management'),
meeting = $('#header-meeting'),
mypage = $('#header-mypage'),
search = $('#header-search'),
membertype = -1,
logintype

var login;
var count = 0;
var no = null;
var index = 0;
$(document).ready(function() {
  getHeaderData()
  
  window.fbAsyncInit = function() {
    FB.init({
      appId : '484853665195171',
      cookie : false,
      xfbml : true,
      version : 'v2.8'
    });
    FB.AppEvents.logPageView();
  };

  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id))
      return;
    js = d.createElement(s);
    js.id = id;
    js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.10&appId=784647978380545";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  $('.header-menu-button').click(function() {
    viewFriend()
    viewRequested()
    console.log(no)
    if (login == -1) {
      $.ajax({
        url: 'http://localhost:8888/alert/get.json',
        type: 'post',
        data:{no: no},
        dataType:'json',
        success: function(result) {
          console.log(result)

          if(result.length > 0) {
            $('.bell-alram').addClass('alram-on')
            $('.bell-alram').text(result.length)
          }
        }
      })
    }

    $(".header-menu-button").toggleClass('header-menu-button-open');
    $(".header-menu-items").toggleClass('header-menu-items-open');
    $('#header-search-bar').val('')

    //메뉴바는 기본적으로 z인덱스가 5
    //화면의 클릭이벤트 z인덱스는 기본적으로 6이다.
    if (index == 0) {
      $('.indexUp').css('z-index', '2') //메뉴바 클릭했을때 화면중앙의 z인덱스 낮춤으로써
      //헤더를 클릭할수 있게 만듬
      index = 1;
      $('.header-menu-items').css('display', '');
      $('.header-menu-items *').css('display', '');
      $('#header-search-bar').css('display', 'none');
    } else if (index == 1) {
      $('.indexUp').css('z-index', '6') //메뉴바를 끌때 화면클릭이벤트는 z인덱스가 2임으로
      //z인덱스를 다시 올려줘야 클릭이 가능하다.
      index = 0;
      $('.header-menu-items').css('display', 'none');
      $('.header-menu-items *').css('display', 'none');
      $('#header-search-bar').css('display', '');
    }

    if (count == 1) {
      $('#header-search-bar').css('display', 'none')
      $('.header-up').css('display', 'none')
      $('.header-none').css('display', 'block')
      $('#header-logo').slideToggle()
      count = 0;
    }
  });

  $('.header-menu-search').click(() => {
    $('.header-none').slideToggle();
    $('.header-up').slideToggle()
    $('#header-logo').slideToggle()

    $('#header-search-bar').slideToggle()

    $('#header-search-bar').focus()
    count = 1;
  })
  $('.header-up').click(() => {
    $('.header-up').slideToggle()
    $('#header-search-bar').val('')
    $('.header-none').slideToggle()
    $('#header-search-bar').slideToggle()
    $('#header-logo').slideToggle()
    count = 0;
  })
  $('#header-meeting').click(function() {
    location.href = '../main/main.html'
  })

  $('#header-management').click(function() {
    if(membertype == -1)
      location.href = '../auth/login.html'
        else if(membertype == 1)
          location.href = '../main/u-login.html'
            else if(membertype == 2)
              location.href= '../main/t-login.html'
  })


  $('.header-logo-bee').click(function() {
    if (no != null)
      location.href = '../chat/chat.html'
        else if (no == null)
          location.href = '../auth/login.html'
  })

});

function getHeaderData() {
  $.getJSON('/auth/userinfo.json', function(result) {
    console.log(result)
    if (result.status != 'fail') {
      no = result.data.no
      membertype = result.data.membertype
      logintype = result.data.accounttype
      $.getJSON('/member/getinfo.json', {'no': no}, function(result) {
        console.log(result)
        if (result.data.profilePicture)
          $('.header-user').attr('src', result.data.profilePicture +'_170.png')

          login = -1;
        $('.header-menu-ul .user-name').text(result.data.name)
        $('.file .profile-img').attr('type', 'file')
        $('#header-li-login').text('Logout')

        profileFiles()

      })
      
      $('#header-li-login').click(() => {
        $.getJSON('/auth/logout.json', function(result) {
          if (result.status != 'fail') {
            console.log('로그인타입', logintype)
            if (logintype == 2) {
              if (Kakao.Auth != undefined) {
                Kakao.Auth.logout() 
                deleteCookie( "kakao_login" );
                createLoginKakao();
              }
              
            } else if (logintype == 1) {
              facebookLogout()
              console.log('페북 로그아웃2')
            }
            
            console.log('로그아웃됨')
            location.href = '../main/main.html'
          
          $('.file .profile-img').attr('type', '')
          $('.bell-alram').removeClass('alram-on')
          $('.bell-alram').text('')
          $('.header-menu-ul .user-name').text('')
          login = 0
          membertype = 0
          }
        })
      })
      
    } else {
      $('#header-li-login').click(() => {
        location.href = '../auth/login.html'
      })
    }
  })
}

function facebookLogout() {
  console.log('페북 드렁왔다')
  FB.getLoginStatus(function(response) {
    console.log(response);
    if (response && response.status === 'connected') {
      FB.logout(function(response) {
        window.location.reload();
      });
    }
  });
}


function viewFriend() {
  $('.mobile-container #users').on('click', function() {
    console.log(membertype)
    if (membertype == 1)
      location.href = '../management/request-match.html'
    else if(membertype == 2)
      location.href = '../management/requested-match.html'
  })
}

function viewRequested() {
  $('#alram').on('click', function() {
    location.href = '../alram/alram.html'
  })
}


function profileFiles() {
  $('#profile-files').fileupload({
    url: '/member/profile-upload.json',        // 서버에 요청할 URL
    dataType: 'json',         // 서버가 보낸 응답이 JSON임을 지정하기
    sequentialUploads: false,  // 여러 개의 파일을 업로드 할 때 순서대로 요청하기.
    singleFileUploads: false, // 한 요청에 여러 개의 파일을 전송시키기.
    autoUpload: true,        // 파일을 추가할 때 자동 업로딩 하지 않도록 설정.
    disableImageResize: /Android(?!.*Chrome)|Opera/
    .test(window.navigator && navigator.userAgent), // 안드로이드와 오페라 브라우저는 크기 조정 비활성 시키기
    processalways: function(e, data) {
      console.log('fileuploadprocessalways()...');
      console.log(data.files);
      data.submit();
    }, 
    submit: function (e, data) { // 서버에 전송하기 직전에 호출된다.
      data.formData = {
          'no': no
      }
      console.log('submit()...');
    }, 
    done: function (e, data) { // 서버에서 응답이 오면 호출된다. 각 파일 별로 호출된다.
      console.log(data.result.data);
      location.reload()
    }
  });
}






