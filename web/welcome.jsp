<%--
  Created by IntelliJ IDEA.
  User: CristyBv
  Date: 24-Mar-18
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
  <%--  <%
        request.setAttribute("page","welcome");
        if(request.getAttribute("go")!="1") request.getRequestDispatcher("/interceptor").forward(request,response);
    %>--%>

    <button onclick="location.href = 'welcome2.jsp';">Pag2</button>

<form action="/logout" method="post">
    <input type="submit" value="Logout"/>
</form>

</body>
</html>
