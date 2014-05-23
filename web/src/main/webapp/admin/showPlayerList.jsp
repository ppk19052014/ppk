<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Club list</title>
</head>

<body>

<table>
    <tr>
        <td>Name</td>
        <td>Position</td>
        <td>Age</td>
        <td>Height</td>
        <td>Weight</td>
        <td>Club id</td>
    </tr>
    <c:forEach var="player" items="${allPlayers}">
        <tr>
            <td>${player.name}</td>
            <td>${player.position}</td>
            <td>${player.age}</td>
            <td>${player.height}</td>
            <td>${player.weight}</td>
            <td>${player.clubId}</td>
            <td><input type="button" value="Edit" onclick="window.location.href='editPlayer.jsp'"></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
