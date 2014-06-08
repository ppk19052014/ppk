<%--@elvariable id="result" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <%}
            else {%>
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
    <section class="page">
        <form method="post">
            <table class="tournamentsTable">
                <tr class="tableHeader">
                    <td>Name</td>
                    <td>Members Count</td>
                    <td>Country</td>
                </tr>
                <%--@elvariable id="allTournaments" type="java.util.List"--%>
                <c:forEach var="tournament" items="${allTournaments}">
                    <tr class="tableRow">
                        <td style="display: none"><label><input type="text" name="tournamentId" value="${tournament.id}"/></label></td>
                        <td onclick="window.location.href='tournamentInfo.jsp?tournamentId=${tournament.id}'">${tournament.name}</td>
                        <td>${tournament.membersCount}</td>
                        <td>${tournament.country}</td>
                        <%
                            Boolean isAdmin = (Boolean) session.getAttribute("admin");
                            if (isAdmin != null && isAdmin) {%>
                        <td><input type="button" value="Edit" onclick="window.location.href='editTournament.jsp?tournamentId=${tournament.id}'"/></td>
                        <td><input type="submit" value="Delete"/></td>
                        <%}%>
                    </tr>
                </c:forEach>
            </table>
        </form>
        ${result}
        <%--<table class="tournamentsTable">--%>
            <%--<tr class="tableHeader">--%>
                <%--&lt;%&ndash;<td>№</td>&ndash;%&gt;--%>
                <%--<td>Name</td>--%>
                <%--<td>Members count</td>--%>
                <%--<td>Country</td>--%>
            <%--</tr>--%>
            <%--<c:forEach var="club" items="${allTournaments}">--%>
                <%--<tr>--%>
                    <%--<label> <input type="text" name="tournamentId" value="${tournament.id}" style="display: none"></label>--%>
                    <%--<td><a href="tournamentInfo.jsp?tournamentId=${tournament.id}"/>${tournament.name}</td>--%>
                    <%--<td>${tournament.membersCount}</td>--%>
                    <%--<td>${tournament.country}</td>--%>
                    <%--<td>--%>
                        <%--<input type="button" value="Edit"--%>
                               <%--onclick="window.location.href='editClub.jsp?clubId=${club.id}'">--%>
                    <%--</td>--%>
                    <%--<td><input type="submit" value="Delete"></td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--<tr class="tableRow">--%>
                <%--<td>Ukrainian Premier League</td>--%>
                <%--<td>16</td>--%>
                <%--<td>Ukraine</td>--%>
            <%--</tr>--%>
            <%--&lt;%&ndash;<tr class="tableRow">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>2</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>La Liga</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>20</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>Country</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<tr class="tableRow">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>3</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>Premier League</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>20</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>England</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<tr class="tableRow">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>4</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>Bundesliga</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>18</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>Germany</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<tr class="tableRow">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>5</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>Serie A</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>20</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>Italy</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<tr class="tableRow">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>6</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>Ligue 1</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>20</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>France</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<tr class="tableRow">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>7</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>Primeira Liga</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>16</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>Portugal</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<tr class="tableRow">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>8</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>Russian Football Premier League</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>16</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td>Russia</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
        <%--</table>--%>
    </section>
</div>
</body>
</html>