<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Club list</title>
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
<%--<table>--%>
    <%--<c:forEach var="club" items="${allClubs}">--%>
        <%--<tr>--%>
            <%--<td>${club.name}</td>--%>
            <%--<td><input type="button" value="Edit" onclick="window.location.href='editClub.jsp'"></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>

</body>
</html>
