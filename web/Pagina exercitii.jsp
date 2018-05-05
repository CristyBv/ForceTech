<%--
  Created by IntelliJ IDEA.
  User: Ioana
  Date: 21.04.2018
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/Pagina_exercitii.css"/>
    <title>Pagina exercitii</title>
    <meta charset="UTF-8">
    <meta name="description" content="Pagina de exercitii">
    <meta name="keywords" content="forcetech, exercitii, fizice">
    <meta name="author" content="ForceTech">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<ul class="menu">
    <li><a href="#home">Home</a></li>
    <li><a href="#profile">Profile</a></li>
    <li><a href="#programs">Programs</a></li>
    <li><a href="#challenges">Challenges</a></li>
</ul>
<%
    Cookie[] cookies = request.getCookies();
    if(cookies!=null)
        for(int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("user")) {
                out.println("<p>" + "Bine ai venit, " + cookies[i].getValue() + "!" + "</p>");
            }
        }
%>
<h1> Exercises </h1>
    <section>


    </section>
<script src="/JS/Design_programe.js"></script>
</body>
</html>
