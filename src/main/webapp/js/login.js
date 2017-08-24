$(document).ready(function() {
  Kakao.init('90a2de4be0ff30607f507187d5b8dcb0');})


  window.fbAsyncInit = function() {
  FB.init({
    appId : '484853665195171',
    cookie : true,
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


$(window).on("load", function() {
  FB.getLoginStatus(function(response) {
    if (response && response.status === 'connected') {
      FB.logout(function(response) {
      });
    }
  });
})


function firstLogin(response) {
  console.log('firstLogin')
  $.post('/auth/login.json', {
    id : response.id,
    pwd : '1111',
    membertype: 1

  }, function(result) {
    console.log(result)
    if ( navigator.platform ) { 
      if ( filter.indexOf( navigator.platform.toLowerCase() ) < 0 ) { 
        if(result.data == 'ok')
          window.history.go(-2)

          else {
            console.log(response)
            if(response.kaccount_email)
              kakaoadd(response)
              else
                facebookadd(response)
          }
      } else { 
        if(result.data == 'ok')
          window.history.go(-1)
          else {
            console.log(response)
            if(response.kaccount_email)
              kakaoadd(response)
              else
                facebookadd(response)
          }
      } 
    }

  }, 'json'); // login.json
}

function kakaoadd(response) {
  console.log('add')
  $.post('/member/add.json', {
    id: response.id,
    pwd: '1111',
    name: response.properties.nickname,
    email: response.kaccount_email,
    accounttype: 2,
    membertype: 1

  }, function(result) {
    console.log('login')
    login(result)

  }, 'json') // kakaoadd.json
}

function facebookadd(response) {
  console.log('add')
  $.post('/member/add.json', {
    id: response.id,
    pwd: '1111',
    name: response.name,
    email: response.email,
    accounttype: 1,
    membertype: 1

  }, function(result) {
    console.log('login')
    login(result)

  }, 'json') // facebookadd.json
}

function login(result) {
  console.log('login')
  $.post('/auth/login.json', {
    id: result.data.id,
    pwd: result.data.pwd,
    membertype: result.data.membertype

  }, function(result) {
    console.log(result)
    if ( navigator.platform ) { 
      if ( filter.indexOf( navigator.platform.toLowerCase() ) < 0 ) { 
        if(result.data == 'ok')
          window.history.go(-2)
      } else { 
        if(result.data == 'ok')
          window.history.go(-1)
      } 
    }
  }, 'json') // login.json
}

$('#kakao').on('click', function() {
  Kakao.Auth.login({
    success: function(authObj) {/*
    location.href='../ekdma/u-login.html'; */
      console.log(JSON.stringify(authObj));
      Kakao.API.request({
        url: '/v1/user/me',
        success: function(response) {
          console.log(response)
          firstLogin(response)

        },
        fail: function(err) {
          alert(JSON.stringify(err));
        }
      })
    }
  })
})



$('#facebook').on('click', function() {
  FB.login(function(response) {
    FB.api('/me?fields=id,name,email', function (response) {
      console.log(JSON.stringify(response));
      firstLogin(response)
    }, {scope: 'public_profile,email'});
  })
})


var loginType = 1;

$('#usertype').click(function() {
  loginType = $(this).val()
})

$('#trainertype').click(function() {
  loginType = $(this).val()
})                        

var filter = "win16|win32|win64|mac|macintel"; 

var sendBtn = $('.send')

sendBtn.on('click', function() {
  $.post('/auth/login.json', {
    'id' : $('.id').val(),
    'pwd': $('.pwd').val(),
    'membertype' : loginType

  }, function(result) {
    if(result.data == 'fail') {
      swal({
        text:"아이디와 비밀번호를 확인해주세요",
        type: "warning",
        confirmButtonText: "확 인",
        confirmButtonColor: '#F7AC1A',
        closeOnConfirm: true,
        animation: false,
        preConfirm: function() {
          location.reload()
        }
      });
    } else {
      FB.getLoginStatus(function(response) {
        if (response && response.status === 'connected') {
          FB.logout(function(response) {
          });
        }
      });
    }
    if ( navigator.platform ) { 
      if ( filter.indexOf( navigator.platform.toLowerCase() ) < 0 ) { 
        if(result.data == 'ok')
          window.history.go(-2)
      } else { 
        if(result.data == 'ok')
          window.history.go(-1)
      } 
    }
  }, 'json')
})


$('.pwd').keyup(function(e) {
  if (e.keyCode == 13)
    sendBtn.click()
})















