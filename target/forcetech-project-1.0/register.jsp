<%--
  Created by IntelliJ IDEA.
  User: CristyBv
  Date: 24-Mar-18
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" type="text/css" href="CSS/Register.css"/>
    <meta charset="UTF-8">
    <meta name="description" content="Prima pagina">
    <meta name="keywords" content="forcetech, sport, register">
    <meta name="author" content="ForceTech">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <img id="logo" src="IMG/logo.png" alt="logo">
    <hr>
    <div id="formular">
         SIGN UP
        <form action="/inregistrare" method="post">
            Name:  <input type="text" name="name" minlength="5"/>
            <br>
            Pass:  <input type="password" name="pass" minlength="2" />
            <br>
            Email:  <input type="email" name="email" />
            <br>
            <input type="submit" value="Register"/>
        </form>
    </div>
<p>${errorregister}</p>
</body>
</html>
