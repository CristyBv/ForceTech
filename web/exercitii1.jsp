<%--
  Created by IntelliJ IDEA.
  User: Ioana
  Date: 25.03.2018
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagina 1 de exercitii</title>
    <link rel="stylesheet" href="/CSS/programe.css" type="text/css"/>

</head>
<body><ul class="menu">
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
<script src="/JS/Design_programe.js"></script>
</body>
</html>
