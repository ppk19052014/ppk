<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>

<form method="post">

    <label><input type="text" name="id" value="${editPlayer.id}" style="display:none;"></label>
    Name:
    <label>
        <input type="text" name="name" value="${editPlayer.name}">
    </label>
    Position:
    <label>
        <select name="position">
            <c:forEach var="pos" items="${positionList}">
                <c:choose>
                    <c:when test="${editPlayer.position == pos}">
                        <option value="${pos}" selected>${pos}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${pos}">${pos}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </label>
    Age:
    <label>
        <select name="age">
            <c:forEach var="i" begin="16" end="50">
                <c:choose>
                    <c:when test="${editPlayer.id == i}">
                        <option value="${i}" selected>${i}></option>
                    </c:when>
                    <c:otherwise>
                        <option value="${i}">${i}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </label>
    Height:
    <label>
        <input type="text" name="height" value="${editPlayer.height}">
    </label>
    Weight:
    <label>
        <input type="text" name="weight" value="${editPlayer.weight}">
    </label>
    Club:
    <label>
        <select name="clubId">
            <c:forEach var="club" items="${clubList}">
                <c:choose>
                    <c:when test="${editPlayer.clubId == club.id}">
                        <option value="${club.id}" selected>${club.name}></option>
                    </c:when>
                    <c:otherwise>
                        <option value="${club.id}">${club.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </label>
    <br><input type="submit" value="Edit">
</form>

</body>
</html>
