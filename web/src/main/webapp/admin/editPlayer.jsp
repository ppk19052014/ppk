<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<header class="header">
    <div class="page_content-wrapper">

        <div class="header_user">
            <a href="http://football.ua/" class="header_link">Sign up</a>
            <a href="admin/admin.jsp" class="button">Sign in</a>
        </div>

        <div class="header_logo-wrapper">
            <a class="header_logo"></a>
        </div>

        <div class="header_form">
            <form class="form-compact">
                <div class="form-compact_inner-wrapper">
                    <div class="form-compact_buttons-placeholder">
                        <button class="button-search" type="submit">Search</button>
                    </div>
                    <div class="form-compact_field-placeholder">
                        <input type="text" class="form-compact_query" placeholder="Input your search">
                    </div>
                </div>
            </form>
        </div>
    </div>
</header>
<nav class="menu_wrapper">
    <div class="menu_width-wrapper">
        <div class="menu_relative-wrapper">
            <ul class="menu_list">
                <li class="menu_item"><a class="menu_link">Main</a></li>
                <li class="menu_item"><a class="menu_link">Feed</a></li>
                <li class="menu_item"><a class="menu_link">Games &amp Tournaments</a></li>
                <li class="menu_item"><a class="menu_link">Video</a></li>
                <li class="menu_item"><a class="menu_link">Photo</a></li>
                <li class="menu_item"><a class="menu_link">Forum</a></li>
            </ul>
        </div>
    </div>

</nav>
<div class="background">
    <section class="page"/>
</div>
<%--<form method="post">--%>

    <%--<label><input type="text" name="id" value="${editPlayer.id}" style="display:none;"></label>--%>
    <%--Name:--%>
    <%--<label>--%>
        <%--<input type="text" name="name" value="${editPlayer.name}">--%>
    <%--</label>--%>
    <%--Position:--%>
    <%--<label>--%>
        <%--<select name="position">--%>
            <%--<c:forEach var="pos" items="${positionList}">--%>
                <%--<c:choose>--%>
                    <%--<c:when test="${editPlayer.position == pos}">--%>
                        <%--<option value="${pos}" selected>${pos}</option>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<option value="${pos}">${pos}</option>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</c:forEach>--%>
        <%--</select>--%>
    <%--</label>--%>
    <%--Age:--%>
    <%--<label>--%>
        <%--<select name="age">--%>
            <%--<c:forEach var="i" begin="16" end="50">--%>
                <%--<c:choose>--%>
                    <%--<c:when test="${editPlayer.id == i}">--%>
                        <%--<option value="${i}" selected>${i}></option>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<option value="${i}">${i}</option>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</c:forEach>--%>
        <%--</select>--%>
    <%--</label>--%>
    <%--Height:--%>
    <%--<label>--%>
        <%--<input type="text" name="height" value="${editPlayer.height}">--%>
    <%--</label>--%>
    <%--Weight:--%>
    <%--<label>--%>
        <%--<input type="text" name="weight" value="${editPlayer.weight}">--%>
    <%--</label>--%>
    <%--Club:--%>
    <%--<label>--%>
        <%--<select name="clubId">--%>
            <%--<c:forEach var="club" items="${clubList}">--%>
                <%--<c:choose>--%>
                    <%--<c:when test="${editPlayer.clubId == club.id}">--%>
                        <%--<option value="${club.id}" selected>${club.name}></option>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<option value="${club.id}">${club.name}</option>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</c:forEach>--%>
        <%--</select>--%>
    <%--</label>--%>
    <%--<br><input type="submit" value="Edit">--%>
<%--</form>--%>

</body>
</html>
