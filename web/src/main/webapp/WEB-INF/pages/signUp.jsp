<%--@elvariable id="result" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../public/style.css"/>
    <title>Sign in page</title>
</head>

<body class="body">

<header class="header">

    <div class="header_user">
        <a href="signIn" class="button">Sign in</a>
    </div>

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
<div class="background" style="height: 2000px">
    <section class="page" style="height: 150px; width: 500px">
        <form method="post" class="signForm">
            <table class="signInTable">
                <tr>
                    <td>Login:</td>
                    <td><label><input type="text" name="login"/></label></td>
                <tr>
                    <td>Password:</td>
                    <td><label><input type="password" name="password"/> </label></td>
                </tr>
                <tr>
                    <td><input class="button" type="submit" value="Sign up"/></td>
                </tr>
            </table>
        </form>
        <label>${result}</label>
    </section>
</div>
</body>
</html>
