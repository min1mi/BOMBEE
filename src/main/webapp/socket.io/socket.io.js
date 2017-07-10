var express = require('express'),
    // routes = require('./routes'),
    http = require('http'),
    path = require('path')

var app = express()
app.use(express.static(path.join(__dirname, '../chat/detail-chat.html')))

var httpServer = http.createServer(app).listen(8080, function(req, res) {
  console.log('Socket IO server has been started')
})

var io = require('socket.io').listen(httpServer)

io.sockets.on('connection', function(socket) {
  socket.emit('toclient', {message:'Welcome !'})
  socket.on('fromclient', function(data) {
    socket.broadcast.emit('toclint', data)
    socket.emit('toclint', data)
    console.log('Message from clinet : ' + data.message);

  })

})
