var socket = new WebSocket("ws://localhost:8080/gs-guide-websocket");
// socket.subscribe('/topic/greetings', function (greeting) {
//     showGreeting(JSON.parse(greeting.body).content);
// });
// socket.send("hello");

socket.onopen = function() {
    alert("Connected");
    var message = {};
    message.name = "testname";
    socket.send(message);
};

socket.onclose = function(event) {
    if (event.wasClean) {
        alert('Connection refused');
    } else {
        alert('Connection killed'); // например, "убит" процесс сервера
    }
    alert('Code: ' + event.code + ' problem: ' + event.reason);
};

socket.onmessage = function(event) {
    alert("Getted data " + event.data);
};

socket.onerror = function(error) {
    alert("Error " + error.message);
};