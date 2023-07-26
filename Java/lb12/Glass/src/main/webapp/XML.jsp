<%--
  Created by IntelliJ IDEA.
  User: Polina
  Date: 26.04.2023
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<x:parse var="doc">
  <c:import url="xml/airport.xml"/>
</x:parse>

<x:forEach select="$doc/airports/airport" var="airp">
  title:
  <x:out select="$airp/company"/><br/>
  author:
  <x:out select="$airp/country"/><br/>
</x:forEach>

</body>
</html>
