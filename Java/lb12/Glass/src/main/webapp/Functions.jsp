<%--
  Created by IntelliJ IDEA.
  User: Polina
  Date: 26.04.2023
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Functions</title>
</head>
<body>
Количество букв в Java = ${fn:length("Java")}

<c:set value="HELLO WORLD" var="str" scope="page"/>
<br/>
Преобразование строки в нижний регистр: ${fn:toLowerCase(str)}

<c:set value="telephone, computer, mouse, monitor" var="str2" scope="page"/>
<br/>
Разбитие на подстроки:
<c:forEach var="sub" items="${fn:split(str2, ',')}">
    ${sub}<br/>
</c:forEach>

<c:set var="str3" value="Hello C++" scope="page"/>
<br/>
Заменим C++ на Java(Hello C++): ${fn:replace(str3, "C++","Java")}

<br/>
Начинется ли строка(${str}) со слова HELLO или нет?
<c:if test="${fn:startsWith(str, 'HELLO')}">
    <h2 >да</h2>
</c:if>

</body>
</html>
