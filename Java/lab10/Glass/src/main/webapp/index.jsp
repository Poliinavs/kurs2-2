<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>



<h1 >Форма входа</h1>

<form class="form" action="${pageContext.servletContext.contextPath}/Controller?command=login" method="post">
    <input type="text" placeholder="Введиddте логин" name="userLogin" size="18" maxlength="30" required>
    <input type="password" placeholder="Введите пароль" name="userPassword" size="18" maxlength="30" required>
    <input type="submit" class="btn" name="buttonUser" value="Войти">
</form>
<a href="reg.jsp"> Регистрация</a>
<% if (request.getParameter("error") != null && request.getParameter("error").equals("true")) { %>
<p style="color: red;">Ошибка авторизации. Пожалуйста, проверьте введенные данные.</p>
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
<%--5--%>

<%--<a href="ServletTable">Serv to table servdddddddddlet</a>--%>
</body>
</html>