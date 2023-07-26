<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Пример JSP-страницы с использованием тегов core</title>
</head>
<body>
<%
  request.setAttribute("name", "John");
  request.setAttribute("age", 30);
%>
<c:choose>
  <c:when test="${not empty name}">
    <p>Привет, ${name}, ${age}!</p>
  </c:when>
  <c:otherwise>
    <p>Пожалуйста, введите ваше имя.</p>
  </c:otherwise>
</c:choose>

<c:set var="user" value="guest" scope="page"/>
<c:if test="${ not empty user and user eq 'guest' }">
  User is Guest
</c:if>
<br>
<c:set var = "num" value="55" scope="page"/>
<c:choose>
  <c:when test="${num < 50}">
    <c:out value="Значение меньше 50"/>
  </c:when>
  <c:when test="${num > 50}">
    <c:out value="Значение больше 50"/>
  </c:when>
</c:choose>
<br>
<c:set var = "numDouble" value="7.32" scope="page"/>
<c:catch var = "formatExc">
  <c:if test="${numDouble<9}">
    <c:out value="Number = ${numDouble} меньше 9"/>
  </c:if>
</c:catch>
<br/>
<hr/>
<c:if test="${not empty formatExc}">
  <c:out value="Неверный тип: ${numDouble}"/>
  <p style="color: red">Сгенерировано исключение</p>
  ${formatExc}
</c:if>
<hr/>

<c:set var="str" value="1. 2 \ 3 - 4 5"/>
<c:forTokens var="token" items="${str}" delims=".\-">
  <c:out value="${token}"/><br/>
</c:forTokens>

<c:import url="IncludeInf.jsp"/>

<br/>
</body>
</html>