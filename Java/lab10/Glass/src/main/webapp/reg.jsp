<%--
  Created by IntelliJ IDEA.
  User: Polina
  Date: 11.04.2023
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="css/styles1.css">
</head>
<body>
<form class="form" action="${pageContext.servletContext.contextPath}/Controller?command=register" method="post">
  <input type="text" placeholder="Введите логин" name="userLogin"size="18" maxlength="30" required>
  <input type="password" placeholder="Введите пароль" name="userPassword"size="18" maxlength="30" required>
  <input type="submit" class="btn" name="buttonRegister" value="Зарегистрироваться">
</form>
<% if (request.getParameter("error") != null && request.getParameter("error").equals("true")) { %>
<p style="color: red;">Ошибка Регистрации. Пожалуйста, проверьте введенные данные.</p>
<% } %>













<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</body>
</html>
