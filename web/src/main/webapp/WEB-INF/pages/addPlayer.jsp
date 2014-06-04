<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <form:form method="post" modelAttribute="player">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><label>
                        <input type="text" name="name"/>
                    </label>
                    </td>
                </tr>
                <tr>
                    <td>Position:</td>
                    <td><label>
                        <input type="text" name="position"/>
                    </label>
                    </td>
                </tr>
                <tr>
                    <td>Birth Day:</td>
                    <td>
                        <label><input type="text" name="birthsDay"/></label>
                    </td>
                </tr>
                <tr>
                    <td>Height:</td>
                    <td><label>
                        <input type="text" name="height" value="180"/>
                    </label>
                    </td>
                </tr>
                <tr>
                    <td>Weight:</td>
                    <td><label>
                        <input type="text" name="weight" value="80"/>
                    </label>
                    </td>
                </tr>
                <tr>
                    <td>Club:</td>
                    <td>
                        <label>
                            <select name="clubId">
                                <c:forEach var="club" items="${clubList}">
                                    <option value="${club.id}" selected>${club.name}</option>
                                </c:forEach>
                            </select>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add"/></td>
                </tr>
            </table>
        </form:form>
        <label>${result}</label>
    </section>
</div>
</body>
</html>
