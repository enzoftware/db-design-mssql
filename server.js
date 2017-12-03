var expreess = require('express');
var app = expreess();
var server = app.listen(3000);

app.use(expreess.static('public'));

console.log("My socket server is running");