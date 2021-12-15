<%--
  Created by IntelliJ IDEA.
  User: alisa
  Date: 15.12.2021
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add</title>
</head>
<h1>Add abonent</h1>
<body>
<form method="post" action="/add">
    <ul>

        <li><lebel>Input Surname:
            <input name="surname" value="${" "}">
        </lebel></li>

        <li><lebel>Input Name:
            <input name="name" value="${" "}">
        </lebel></li>

        <li><lebel>Input Phone number:
            <input name="phoneNumber" value="${" "}">
        </lebel></li>
    </ul>
    <br>
    <button type="submit" name="addAbonent"> Add abonent </button>
    <br>
    ${message}
    <br>
    <a href="<c:url value="/index"/>">Back</a>
</form>
</body>
</html>
