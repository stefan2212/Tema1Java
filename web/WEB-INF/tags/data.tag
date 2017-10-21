<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@attribute name="categoryId" required="true" type="java.lang.Integer" %>

<sql:setDataSource var="dataSource" driver="org.postgresql.Driver" url="jdbc:postgresql://192.168.56.101/java"
                   user="postgres" password=""/>

<sql:query var="result" dataSource="${dataSource}">
    select data.id as "key", data.value as "value" from data join categories on data.category_id= categories.id where categories.id = ? ;
    <sql:param value="${categoryId}"/>
</sql:query>
${categoryId}
<div class="container" style="margin-top: 30px">
    <table class="highlight centered">
        <thead>
        <tr>
            <th>Key</th>
            <th>Value</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${result.rows}" var="row">
            <tr>
                </td>
                <td>
                        <c:out value="${row.key}"/>
                <td>
                    <c:out value="${row.value}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>