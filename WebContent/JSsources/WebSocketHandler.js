/**
 * var webSocket = new WebSocket("wss://" + location.hostname + ":" + location.port + "/examples/chat");

if ('WebSocket' in window) {
    ws = new WebSocket(target);
} else if ('MozWebSocket' in window) {
    ws = new MozWebSocket(target);
} else {
    alert('WebSocket is not supported by this browser.');
    return;
}

webSocket.onclose = function () { alert("WebSocket connection closed") };
 * alert("wss://" + location.hostname + ":" + location.port + "/chat");
 */

