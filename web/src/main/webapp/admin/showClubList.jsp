<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Club list</title>
</head>

<body>

<table>
    <c:forEach var="club" items="${allClubs}">
        <tr>
            <td>${club.name}</td>
            <td><input type="button" value="Edit" onclick="window.location.href='editClub.jsp'"></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
