<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../public/style.css"/>
    <title></title>
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
<div class="background">
    <section class="page" style="height: auto">
        <label> <input type="text" name="tournamentId" value="${tournament.id}" style="display: none"/></label>
        <label>${tournament.name}</label>
        <table class="tournamentsTable">
            <tr class="tableHeader">
                <td>№</td>
                <td>Club name</td>
            </tr>
            <%int i = 0;%>
            <c:forEach var="club" items="${allClubs}">
                <tr class="tableRow">
                    <label> <input type="text" name="clubId" value="${club.id}" style="display: none"/></label>
                    <td><%=++i%></td>
                    <td onclick="window.location.href='clubInfo.jsp?clubId=${club.id}'">${club.name}</td>
                </tr>
            </c:forEach>
        </table>
            <button class="button" onclick="window.location.href='seasonResult.jsp?tournamentId=${tournament.id}'">Generate results</button>

    </section>
</div>
</body>
</html>