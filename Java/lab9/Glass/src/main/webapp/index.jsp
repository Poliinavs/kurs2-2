<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2><%= "Please, press the button" %>
</h2>

<form action="Lab_9">
    <button style="background: #644e4e; border-radius: 10px; width: 200px; height: 40px">Нажми на меня</button>
</form>

<h1>Форма входа</h1>

<form action="ServletAv">
    <label for="login">Логин:</label>
    <input type="text" id="login" name="login"><br>
    <label for="password">Пароль:</label>
    <input type="password" id="password" name="password"><br>
    <input type="submit" value="Войти">
</form>
<% if (request.getParameter("error") != null && request.getParameter("error").equals("true")) { %>
<p style="color: red;">Ошибка авторизации. Пожалуйста, проверьте введенные данные.</p>
<% } %>
<%--5--%>
<form action="AvtorFive">
    <button style="background: #644e4e; margin:10px; border-radius: 10px; width: 200px; height: 40px">задание 5</button>
</form>

</body>
</html>