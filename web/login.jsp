<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/logare" method="post">
    Name: <input type="text" name="name" width="30"/>
    Pass: <input type="password" name="pass" width="10"/>
    <input type="submit" value="Login"/>
</form>

<p>${errorlogin}</p>

</body>
</html>
