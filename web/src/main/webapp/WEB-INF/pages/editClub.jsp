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
            <a href="signOut" class="header_link">Sign out</a>
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
<div class="background" style="height: 2000px">
    <section class="page" style="height: 250px; width: 600px">
        <form method="post">
            <table>
                <tr>
                    <label><input type="text" name="id" value="${editClub.id}" style="display:none;"/></label>
                    <td>Name:</td>
                    <td>
                        <label><input type="text" name="name" value="${editClub.name}"/></label>
                    </td>
                </tr>
                <tr>
                    <td>Found Date:</td>
                    <td>
                        <label><input type="text" name="foundDate" value="${editClub.foundDate}"/></label>
                    </td>
                </tr>
                <tr>
                    <td>Tournament:</td>
                    <td>
                        <label>
                            <select name="tournamentId">
                                <c:forEach var="tournament" items="${tournamentList}">
                                    <c:choose>
                                        <c:when test="${editClub.tournamentId == tournament.id}">
                                            <option value="${tournament.id}" selected>${tournament.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${tournament.id}">${tournament.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Edit"/></td>
                </tr>
            </table>
        </form>
        <label>${result}</label>
    </section>
</div>
</body>
</html>

