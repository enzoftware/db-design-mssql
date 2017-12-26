var express = require('express');
var app = express();
var server = app.listen(3000);
var socket = require('socket.io');
var io = socket(server);

app.use(express.static('public'));


io.sockets.on('connection', newConnection);

function newConnection(socket){
    console.log('new connection ' + socket.id);
    socket.on('mouse',mouseMessage);
    socket.on('send_message',messagePrint);

    function messagePrint(data){
      io.sockets.emit('new_message',data);
    }

    function mouseMessage(data){
        socket.broadcast.emit('mouse',data);
        console.log(data);
    }
}

console.log("My socket server is running");
