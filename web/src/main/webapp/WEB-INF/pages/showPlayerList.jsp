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
<div class="background" style="height: 2000px">
    <section class="page" style="height: 250px; width: 600px">
        <form method="post">
        <table>
            <tr>
                <td>Name</td>
                <%--<td>Position</td>--%>
                <%--<td>Age</td>--%>
                <%--<td>Height</td>--%>
                <%--<td>Weight</td>--%>
                <%--<td>Club</td>--%>
            </tr>
            <c:forEach var="player" items="${allPlayers}">
                <tr>
                    <label> <input type="text" name="playerId" value="${player.id}" style="display: none"></label>
                    <td>${player.name}</td>
                    <%--<td>${player.position.getName}</td>--%>
                    <%--<td>${player.age}</td>--%>
                    <%--<td>${player.height}</td>--%>
                    <%--<td>${player.weight}</td>--%>
                    <%--<td>${player.clubName}</td>--%>
                    <td><input type="button" value="Edit" onclick="window.location.href='editPlayer.jsp?playerId=${player.id}'"></td>
                    <td><input type="submit" value="Delete"></td>
                </tr>
            </c:forEach>
        </table>
        </form>
        ${result}
    </section>
</div>
</body>
</html>