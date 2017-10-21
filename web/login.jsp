<%--
  Created by IntelliJ IDEA.
  User: StefanC
  Date: 21.10.2017
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> ${name} </h1>

<form action="/LoginServlet" method = "POST">
    Username : <input type = "text" name ="username"> <br>
    Password : <input type = "password" name ="password"> <br>
    <input type = "submit" value ="login">
</form>

</body>
</html>
