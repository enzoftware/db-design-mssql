var express = require('express');
var socket = require('socket.io');
var fs = require('fs');
var app = express();
var server = app.listen(3000);

var io = socket(server);
var nicknames = [];

fs.readFile('palabras.txt','utf8',function(err,data){
  if (err) throw err;
  var array = data.toString().split("\n");
  for(i in array){
    console.log(array[i]);
  }
});

app.use(express.static('public'));


io.sockets.on('connection', newConnection);

function newConnection(socket){
    console.log('new connection ' + socket.id);
    socket.on('mouse',mouseMessage);
    socket.on('send_message',messagePrint);
    socket.on('new_user',newUserEntry);
    socket.on('disconnect',disconnectUser);

    function disconnectUser(data){
      if (!socket.nickname) return;
      nicknames.splice(nicknames.indexOf(socket.nickname),1);
      updateNicknames();
    }

    function updateNicknames(){
      io.sockets.emit('usernames',nicknames);
    }

    function newUserEntry(data, callback){
      if (nicknames.indexOf(data) != -1) {
        callback(false);
      }else {
        callback(true);
        socket.nickname = data;
        nicknames.push(socket.nickname);
        io.sockets.emit('usernames',nicknames);
      }
    }

    function messagePrint(data){
      io.sockets.emit('new_message',{msg : data , nick : socket.nickname });
    }

    function mouseMessage(data){
        socket.broadcast.emit('mouse',data);
    }
}

console.log("My socket server is running!!");
