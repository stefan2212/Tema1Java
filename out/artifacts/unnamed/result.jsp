<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "ex" uri = "WEB-INF/custom.tld"%>

<%--
  Created by IntelliJ IDEA.
  User: StefanC
  Date: 14.10.2017
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> I have been redirected here</h1>
<table border="2px">
    <c:forEach var="item" items="${name}">
        <tr>
            <td> ${item.key} </td>
            <td> ${item.value} </td>
            <td>${item.category.category}</td>
        </tr>
    </c:forEach>
</table>

<ex:Hello/>

</body>
</html>
