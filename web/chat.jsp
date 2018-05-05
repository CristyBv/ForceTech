<%--
  Created by IntelliJ IDEA.
  User: CristyBv
  Date: 05-May-18
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
    <script src="JS/chat.js"></script>
</head>
<body>
    <textarea id="messagesChat" readonly rows="10" cols="45"></textarea>
    <input type="text" id="messagesWrite" size="50"/>
    <input type="button" value="Send" onclick="sendMessage()"/>
</body>
</html>
