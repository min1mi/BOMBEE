var message = $('#message'),
    sendBtn = $('#sendBtn');

var ws = new WebSocket('ws://192.168.0.19:8888/chat/chat.json');
ws.onopen = function (event) {
}

ws.onmessage = function (event) {
 console.log(event.data);
};


sendBtn.click(() => {
  var value = message.val();
  ws.send(value.replace('\n', '').replace('\r', '') + '\n')
  message.val('')

})

message.keyup((e) => {
  if (e.keyCode == 0x0d) {
    var text = message.val().replace('\r', '').replace('\n', '')
    message.val(text)
    sendBtn.click() // send 버튼에 click이벤트 발생시킴, 호출X
  }
})
