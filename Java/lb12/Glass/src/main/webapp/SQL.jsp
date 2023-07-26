<%--
  Created by IntelliJ IDEA.
  User: Polina
  Date: 26.04.2023
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
                   url = "jdbc:mysql://localhost:3306/Production?autoReconnect=true&useSSL=false"
                   user = "root"  password = "1111"/>
<sql:query dataSource = "${snapshot}" var = "result">
    SELECT * from product;
</sql:query>
<table>
    <tr>
        <th>name</th>
        <th>group</th>
        <th>discription</th>
        <th>parametrs</th>
    </tr>

    <c:forEach var = "row" items = "${result.rows}">
        <tr>
            <td> <c:out value = "${row.name}"/></td>
            <td> <c:out value = "${row.group1}"/></td>
            <td> <c:out value = "${row.discription}"/></td>
            <td> <c:out value = "${row.param}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
