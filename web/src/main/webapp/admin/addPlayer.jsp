<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>Add player page</title>
</head>
<body>
<form method="post">
    Name:
    <label>
        <input type="text" name="name">
    </label>
    Position:
    <label>
        <select name="positionSelect">
            <c:forEach var="position" items="${positionList}">
                <option value="${position}">${position.id}</option>
            </c:forEach>
        </select>
    </label>
    Age:
    <label>
        <select name="ageSelect">
            <c:forEach var="i" begin="16" end="50">
                <option value="${i}">${i}</option>
            </c:forEach>
        </select>
    </label>
    Height:
    <label>
        <input type="text" name="height">
    </label>
    Weight:
    <label>
        <input type="text" name="weight">
    </label>
    Club:
    <label>
        <select name="positionSelect">
            <c:forEach var="club" items="${clubList}">
            <option value="${club.id}">${club.name}</option>
            </c:forEach>
    </label>
    <br><input type="submit" value="Add">
</form>
</body>
</html>
