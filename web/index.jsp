<%@ page import="java.util.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="CSS/Index.css"/>
    <title>Welcome</title>
    <meta charset="UTF-8">
    <meta name="description" content="Prima pagina">
    <meta name="keywords" content="forcetech, sport, welcome">
    <meta name="author" content="ForceTech">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script>
      var errorLogin = '${verif}';
    </script>
    <script src="JS/index.js"></script>
    <!--//am declarat variabila errorLogin inainte de a deschide fisierul, deci va fi vizibila in fisierul index.js-->
  </head>
  <body>
    <%Date data=new Date();
      out.println("<h2>"+data+"</h2>");%>
    <img id="logo" src="IMG/logo.png" alt="logo">
    <hr>
    <%
      Cookie[] cookies = request.getCookies();
      if(cookies!=null)
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals("user")) {
            out.println("<p>" + "Bine ai venit, " + cookies[i].getValue() + "!" + "</p>");
          }
        }
    %>
    <p class="p1">
      Join us in a 360 degrees transformation!
    </p>

    <button id="login" onclick="location.href = 'login.jsp';">Login</button>
    <button id="signin" onclick="location.href = 'register.jsp';">Sign In</button>
    <button id="profile" onclick="location.href = 'profile.jsp';">Profil</button>
    <form action="/logout" method="post">
      <input id="submit" type="submit" value="Logout"/>
    </form>
    <br>
    <div class="container" align="center">
      <img class="mySlides" src="IMG/slideshow1.jpg" style=" width: 50%; height: 50%">
      <img class="mySlides" src="IMG/slideshow2.jpg" style=" width: 50%; height: 50%">
      <img class="mySlides" src="IMG/slideshow3.jpg" style=" width: 50%; height: 50%">

      <!--
      <button class="leftbutton" onclick="plusDivs(-1)">&#10094;</button>
      <button class="rightbutton" onclick="plusDivs(1)">&#10095;</button>-->
    </div>

  </body>
</html>
