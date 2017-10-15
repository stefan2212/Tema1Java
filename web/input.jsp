<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: StefanC
  Date: 14.10.2017
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src='https://www.google.com/recaptcha/api.js'></script>
    <title>Title</title>
</head>
<body>
<h1> Hello </h1>

<%--<h1> cookies are:</h1>--%>
<%--<c:forEach var="item" items="${cookie}">--%>
    <%--<h1> ${item}</h1>--%>
<%--</c:forEach>--%>

<form action="/ResultServlet" method="POST">
    <input type="text" name="key"> <br>
    <input type ="text" name="value"> <br>
    <select name="selector">
        <option value=${cookie.cookie.value}>${cookie.cookie.value}</option>
        <c:forEach var="item" items="${name}">
            <option value= ${item.id}> ${item.category} </option>
        </c:forEach>
    </select>
    <br>
    <div class="g-recaptcha" data-sitekey="6LerezQUAAAAAFbPrR0z9LX_fKo895k-V0gclZyZ"></div>
    <br>
    <input type="submit" value="apasa">
</form>


</body>
</html>
