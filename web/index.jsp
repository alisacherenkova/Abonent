<%--
  Created by IntelliJ IDEA.
  User: alisa
  Date: 14.12.2021
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Abonents</title>
</head>
<body>
<h1>Abonents</h1>
<div>
    <button type="submit" name="add" value="/add">
        Add abonent
    </button>
    <br>
    <ul>
        <c:forEach items="${a}" var="abonent">
            <li>${abonent} <a href="<c:url value="/abonent/${abonent.id}"/>">Go to </a>
                <form method="post" action="<c:url value="/index"/>">
                    <button type="submit" name="delete" value="${abonent.id}">
                        Delete
                    </button>
                </form>
            </li>

        </c:forEach>
    </ul>

</div>
</body>
</html>
