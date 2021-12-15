<%--
  Created by IntelliJ IDEA.
  User: alisa
  Date: 14.12.2021
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Abonent</title>
</head>
<body>
<form method="post" action="/abonent/${abonent.id}">
    <ul>
        <li><lebel>Id:
            ${abonent.id}
        </lebel></li>

        <li><lebel>Surname:
            <input name="surname" value="${abonent.surname}">
        </lebel></li>

        <li><lebel>Name:
            <input name="name" value="${abonent.name}">
        </lebel></li>

        <li><lebel>Phone number:
            <input name="phoneNumber" value="${abonent.phoneNumber}">
        </lebel></li>
    </ul>
    <br>
        <button type="submit" name="update"> Update abonent </button>
    <br>
    ${message}
    <br>
    <a href="<c:url value="/index"/>">Back</a>
</form>
</body>
</html>
