$(document).ready(function() {
  Kakao.init('90a2de4be0ff30607f507187d5b8dcb0');})

$(window).on("load", function() {
  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });
})

$('#kakao').on('click', function() {
  Kakao.Auth.login({
    success: function(authObj) {/* 
    location.href='../ekdma/u-login.html'; */
      console.log(JSON.stringify(authObj));
    },
    fail: function(err) {
      alert(JSON.stringify(err));
    }
  })
})

$('#logout').on('click', function() {
  Kakao.Auth.logout(function() {
      console.log('응 아니야');
  })
  FB.logout(function(response){
    console.log("로그아웃됬따")
  });
})

$('#facebook').on('click', function() {/* 
  location.href='../ekdma/t-login.html' */
  FB.login(function(response) {
    FB.api('/me?fields=id,name,email', function (response) {

      console.log(JSON.stringify(response));
  });

   }, {scope: 'public_profile,email'});

})


$('.send').on('click', function() {
  $.post('/auth/login.json', {
    'id' : $('.id').val(),
    'pwd': $('.pwd').val()
    
  }, function(result) {
    location.href = '../main/main.html'
      
  }, 'json')
  
})








/**/