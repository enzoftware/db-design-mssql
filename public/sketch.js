var socket;
var canvas;
var words;
var theChosenWord;

function setup(){
    canvas = createCanvas( int (( $('#container').width() / 12 ) * 10 )  , 330); // $('#contentWrap').width()
    console.log(canvas.width);
    canvas.parent('canvasContainer');
    background(51);
    socket = io.connect('http://localhost:3000');
    var messageForm = $('#send-message');
    var nickForm = $('#setNick');
    var nickError = $('#nickError');
    var nickname = $('#nickname');
    var users = $('#users');
    var wordHtml = $('#word');
    var messageBox = $('#message');
    var chat = $('#chat');

    nickForm.submit(function(e){
      e.preventDefault();
      socket.emit('new_user',nickname.val() , function(data){
        if (data) {
          $('#nickWrap').hide();
          $('#contentWrap').show();
        }else {
          nickError.html('That user name is taken :( ');
        }
      });
      nickname.val('');
    });

    messageForm.submit(function(e){
      e.preventDefault();
      socket.emit('send_message',messageBox.val());
      console.log(messageBox.val());
      messageBox.val('');
    });

    socket.on('mouse',newDrawing);

    socket.on('new_message', reciveMessage);

    socket.on('usernames', showUsers);

    socket.on('words',settingUpWords);

    function settingUpWords(data){
      words = data.toString().split(',');
      theChosenWord = words[ Math.floor( Math.random() * 10782 ) + 1 ];
      wordHtml.html(theChosenWord);
    }

    function showUsers(data){
        var html = ''
        console.log(data);
        for (var i = 0; i < data.length; i++) {
          html += '<b>' +  data[i] + ' </b> <br/>';
        }
        users.html(html);
    }

    function reciveMessage(data){
      console.log(data);
      if(data.msg != '') {
        chat.append('<b>' + data.nick + ' : </b>' + data.msg + '<br/>');
      }else {
        alert("Empty message");
      }
    }

    function newDrawing(data){
        noStroke();
        fill(125);
        ellipse(data.x,data.y,10,10);
    }
}



function mouseDragged(){
    var data = {
        x : mouseX,
        y : mouseY
    };

    socket.emit('mouse',data);

    noStroke();
    fill(255);
    ellipse(mouseX,mouseY,10,10);
}
