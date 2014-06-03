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

            <label><input type="text" name="id" value="${editPlayer.id}" style="display:none;"></label>
            <table>
            <tr>
                <td>Name:</td>
                <td><label><input type="text" name="name" value="${editPlayer.name}"></label></td>
            </tr>
            <tr>
                <td>Position:</td>
                <td><label>
                    <input type="text" name="position" value="${editPlayer.position}">
                </label>
                </td>
            </tr>
            <tr>
                <td>Births Day:</td>
                <td>
                    <label>
                        <input type="text" name="height" value="${editPlayer.birthsDay}">
                    </label>
                </td>
            </tr>
            <tr>
                <td>Height:</td>
                <td>
                    <label>
                        <input type="text" name="height" value="${editPlayer.height}">
                    </label>
                </td>
            </tr>
            <tr>
                <td>Weight:</td>
                <td>
                    <label>
                        <input type="text" name="weight" value="${editPlayer.weight}">
                    </label>
                </td>
            </tr>
            <tr>
                <td>Club:</td>
                <td>
                    <label>
                        <select name="clubId">
                            <c:forEach var="club" items="${clubList}">
                                <c:choose>
                                    <c:when test="${editPlayer.clubId == club.id}">
                                        <option value="${club.id}" selected>${club.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${club.id}">${club.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </label>
                </td>
            </tr>
            <tr><td><input type="submit" value="Edit"></td></tr>
            </table>
        </form>
        <label>${result}</label>
    </section>
</div>
</body>
</html>
