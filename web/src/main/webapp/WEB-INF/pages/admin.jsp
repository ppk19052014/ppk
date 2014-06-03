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
        <br><a href="showClubs">Show clubs list</a>
        <br><a href="addClub">Add club page</a>
        <br><a href="showPlayers">Show players list</a>
        <br><a href="addPlayer">Add player page</a>
        <br><a href="showTournaments">Show tournaments list</a>
        <br><a href="addTournament">Add tournaments page</a>
    </section>
</div>
</body>
</html>
