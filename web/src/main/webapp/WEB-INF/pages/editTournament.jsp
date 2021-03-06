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
    <section class="page">
        <form method="post">
            <table>
                <tr>
                    <label><input type="text" name="id" value="${editTournament.id}" style="display:none;"/></label>
                    <td>Name:</td>
                    <td>
                        <label><input type="text" name="name" value="${editTournament.name}"/></label>
                    </td>
                </tr>
                <tr>
                    <td>Members count:</td>
                    <td>
                        <label><input type="text" name="membersCount" value="${editTournament.membersCount}"/></label>
                    </td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td>
                        <label><input type="text" name="country" value="${editTournament.country}"/></label>
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

