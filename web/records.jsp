<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: StefanC
  Date: 21.10.2017
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action ="/RecordsServlet" method ="POST">
    <select name="selector">
        <c:forEach var="item" items="${name}">
            <option value= ${item.id}> ${item.category} </option>
        </c:forEach>
    </select>
    <input type ="submit" value="submit">
</form>
</body>
</html>
