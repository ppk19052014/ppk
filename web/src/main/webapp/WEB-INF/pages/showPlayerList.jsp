<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../public/style.css"/>
    <title>Sign in page</title>
</head>

<body class="body">

<header class="header">
    <div class="page_content-wrapper">

        <div class="header_user">
            <%
                Boolean isSignedId = (Boolean) session.getAttribute("signedIn");
                if (isSignedId != null && isSignedId) {%>
            <a href="signOut" class="header_link">Sign out</a>
            <%} else {%>
            <a href="signUp" class="header_link">Sign up</a>
            <a href="signIn" class="button">Sign in</a>
            <%
                }
            %>
        </div>

        <div class="header_form">
            <form class="form-compact">
                <div class="form-compact_inner-wrapper">
                    <div class="form-compact_buttons-placeholder">
                        <button class="button-search" type="submit">Search</button>
                    </div>
                    <div class="form-compact_field-placeholder">
                        <input type="text" class="form-compact_query" placeholder="Input your search"/>
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
                <li class="menu_item"><a href="main" class="menu_link">Main</a></li>
                <li class="menu_item"><a class="menu_link">Feed</a></li>
                <li class="menu_item"><a href="showTournaments" class="menu_link">Games &amp Tournaments</a></li>
                <li class="menu_item"><a class="menu_link">Video</a></li>
                <li class="menu_item"><a class="menu_link">Photo</a></li>
                <li class="menu_item"><a class="menu_link">Forum</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="background" style="height: 2000px">
    <section class="page">
        <form method="post">
            <table class="tournamentsTable">
                <tr class="tableHeader">
                    <td>Name</td>
                    <td>Position</td>
                    <td>Birth Day</td>
                    <td>Height</td>
                    <td>Weight</td>
                    <td>Club</td>
                </tr>
                <c:forEach var="player" items="${allPlayers}">
                    <tr class="tableRow">
                        <label> <input type="text" name="playerId" value="${player.id}" style="display: none"/></label>
                        <td>${player.name}</td>
                        <td>${player.position}</td>
                        <td>${player.birthsDay}</td>
                        <td>${player.height}</td>
                        <td>${player.weight}</td>
                        <td>${player.clubName}</td>
                        <%
                            Boolean isAdmin = (Boolean) session.getAttribute("admin");
                            if (isAdmin != null && isAdmin) {%>
                        <td><input type="button" value="Edit" onclick="window.location.href='editPlayer.jsp?playerId=${player.id}'"/></td>
                        <td><input type="submit" value="Delete"/></td>
                        <%}%>
                    </tr>
                </c:forEach>
            </table>
        </form>
        ${result}
    </section>
</div>
</body>
</html>