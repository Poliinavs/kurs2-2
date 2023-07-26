<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>


<a href="Servlet3_1">Перейти к первому сервлету через get запрос</a>
<form action="Servlet6_a" method="post">
    <input type="text" name="param1" placeholder="Param1">
    <input type="text" name="param2" placeholder="Param2">
    <input type="submit" value="Submit">
</form>
<h1><a href="Servlet6ab">Задание 6b с первого на второй со второго на стр</a> </h1>
<h1><a href="Servlet6с">Задание 6 c переадресацией</a> </h1>
<h1><a href="Servlet7_1">Задание 7</a> </h1>
</body>
</html>