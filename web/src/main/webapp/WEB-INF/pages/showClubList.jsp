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
                    <td>Found Date</td>
                </tr>
                <c:forEach var="club" items="${allClubs}">
                    <tr>
                        <label> <input type="text" name="clubId" value="${club.id}" style="display: none"></label>
                        <td>${club.name}</td>
                        <td>${club.foundDate}</td>
                        <td>
                            <input type="button" value="Edit"
                                   onclick="window.location.href='editClub.jsp?clubId=${club.id}'">
                        </td>
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
