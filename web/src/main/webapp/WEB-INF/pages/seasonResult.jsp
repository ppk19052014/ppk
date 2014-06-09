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

        Tournament result table for ${season.years}
        <table class="tournamentsTable">
            <tr class="tableHeader">
                <td>№</td>
                <td>Club</td>
                <td>G</td>
                <td>W</td>
                <td>D</td>
                <td>L</td>
                <td>GS</td>
                <td>GM</td>
                <td>GD</td>
                <td>Pt</td>
            </tr>
            <tr class="tourRow">
                <td>1.</td>
                <td onclick="window.location.href='clubInfo.jsp?clubId=${seasonResultList[0].clubId}'">${seasonResultList[0].clubName}</td>
                <td>${seasonResultList[0].getGamesCount()}</td>
                <td>${seasonResultList[0].winCount}</td>
                <td>${seasonResultList[0].drawCount}</td>
                <td>${seasonResultList[0].loseCount}</td>
                <td>${seasonResultList[0].getGoalScored()}</td>
                <td>${seasonResultList[0].getGoalMissed()}</td>
                <td>${seasonResultList[0].getGoalDifference()}</td>
                <td>${seasonResultList[0].getPoints()}</td>
            </tr>
            <c:forEach var="i" begin="1" end="${fn:length(seasonResultList)-1}">
                <tr>
                    <td>${i+1}.</td>
                    <td onclick="window.location.href='clubInfo.jsp?clubId=${seasonResultList[i].clubId}'">${seasonResultList[i].clubName}</td>
                    <td>${seasonResultList[i].getGamesCount()}</td>
                    <td>${seasonResultList[i].winCount}</td>
                    <td>${seasonResultList[i].drawCount}</td>
                    <td>${seasonResultList[i].loseCount}</td>
                    <td>${seasonResultList[i].getGoalScored()}</td>
                    <td>${seasonResultList[i].getGoalMissed()}</td>
                    <td>${seasonResultList[i].getGoalDifference()}</td>
                    <td>${seasonResultList[i].getPoints()}</td>
                </tr>
            </c:forEach>
        </table>

        <b>Our congratulations for ${seasonResultList[0].clubName}, they are the CHAMPIONS!!!</b>

        <table class="tournamentsTable">
            <tr class="tableHeader">
                <td>Game calendar for ${season.years}</td>
            </tr>
            <%int j = 0;%>
            <c:forEach var="tour" items="${season.tourList}">
                <tr class="tourRow">
                    <td>Tour <%=++j%> ${tour[0].date}:</td>
                </tr>
                <c:forEach var="game" items="${tour}">
                    <tr>
                        <td>${game}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>

    </section>
</div>
</body>
</html>