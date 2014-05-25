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
            Name:
            <label>
                <input type="text" name="name">
            </label>
            Position:
            <label>
                <select name="positionSelect">
                    <c:forEach var="position" items="${positionList}">
                        <option value="${position}">${position.id}</option>
                    </c:forEach>
                </select>
            </label>
            Age:
            <label>
                <select name="ageSelect">
                    <c:forEach var="i" begin="16" end="50">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </label>
            Height:
            <label>
                <input type="text" name="height">
            </label>
            Weight:
            <label>
                <input type="text" name="weight">
            </label>
            Club:
            <label>
                <select name="positionSelect">
                    <c:forEach var="club" items="${clubList}">
                    <option value="${club.id}">${club.name}</option>
                    </c:forEach>
            </label>
            <br><input type="submit" value="Add">
        </form>
    </section>
</div>
</body>
</html>
