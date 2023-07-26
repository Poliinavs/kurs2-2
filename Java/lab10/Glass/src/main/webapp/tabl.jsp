<%@ page import="java.util.List" %>
<%@ page import="com.iris.glass.ServletTable" %>
<%@ page import="com.iris.glass.Model.aircompany" %><%--
  Created by IntelliJ IDEA.
  User: Polina
  Date: 11.04.2023
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        var xhr = new XMLHttpRequest();
        var url = 'http://localhost:8080/Glass-1.0-SNAPSHOT/ServletAv';
        var params = 'login=' + encodeURIComponent('admin') + '&password=' + encodeURIComponent('111');
        xhr.open('POST', url, true);
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr.onload = function() {
            if (xhr.status === 200) {
                var response = xhr.responseText;
                // обрабатываем полученные данные
            }
        };
        xhr.send(params);
    </script>
    <link rel="stylesheet" href="css/styles2.css">
</head>
<body>



<table border="1">
    <tr>

        <th>Airplane</th>
        <th>Country</th>
        <th>Day</th>
    </tr>
    <%
        List<aircompany> myList = (List<aircompany>) request.getAttribute("myDataList");
        if (myList != null) {
            for (aircompany item : myList) {
    %>
    <tr>
        <td><%= item.airplane %></td>
        <td><%= item.country %></td>
        <td><%= item.day %></td>
    </tr>
    <%
            }
        }
    %>
</table>
<h1>Add</h1>
<form action="${pageContext.servletContext.contextPath}/Controller?command=add_new_person" method="post">
    <label for="compay">Country:</label>
    <input type="text" value="company" onclick="this.value=''"  id="compay" name="compay"><br>
    <label for="country">Data:</label>
    <input type="text" value="country" onclick="this.value=''"  id="country" name="country"><br>
    <label for="day">Company:</label>
    <input type="text" value="day" onclick="this.value=''"  id="day" name="day"><br>
    <input type="submit" value="Company">
</form>
<h1>Del: </h1>
<form action="${pageContext.servletContext.contextPath}/Controller?command=remove" method="post">
    <input type="text" name="name" placeholder="Enter company" required>
    <input type="submit" name="btn2" value="Удалить">
</form>
<%--<form aaction="${pageContext.servletContext.contextPath}/Controller?command=remove" method="post">
<input type="text" value="company" onclick="this.value=''"  id="comp" name="comp"><br>
<label for="comp">Enter Company:</label>
<input type="submit" value="Del">
</form>--%>
</body>
</html>
