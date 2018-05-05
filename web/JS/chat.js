/**
 * Created by CristyBv on 05-May-18.
 */

var websocket = new WebSocket("ws://localhost:8080/chatserver")
websocket.onmessage = function processMessage(message) {
    var chat = document.getElementById("messagesChat");
    chat.value += message.data + '\n';
}

function sendMessage() {
    var message = document.getElementById("messagesWrite");
    websocket.send(message.value);
    message.value = "";
}