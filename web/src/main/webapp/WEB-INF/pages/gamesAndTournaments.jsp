<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../public/style.css"/>
    <title></title>
</head>
<body class="body">
<header class="header">
    <div class="page_content-wrapper">

        <div class="header_user">
            <a href="signIn" class="header_link">Sign up</a>
            <a href="signIn" class="button">Sign in</a>
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
                <li class="menu_item"><a href="/index.jsp" class="menu_link">Main</a></li>
                <li class="menu_item"><a class="menu_link">Feed</a></li>
                <li class="menu_item"><a class="menu_link">Games &amp Tournaments</a></li>
                <li class="menu_item"><a class="menu_link">Video</a></li>
                <li class="menu_item"><a class="menu_link">Photo</a></li>
                <li class="menu_item"><a class="menu_link">Forum</a></li>
            </ul>
        </div>
    </div>

</nav>
<div class="background">
    <section class="page">
        <table class="tournamentsTable">
            <tr class="tableHeader">
                <td>№</td>
                <td>Name</td>
                <td>Members count</td>
                <td>Country</td>
            </tr>
            <tr class="tableRow">
                <td>1</td>
                <td>Ukrainian Premier League</td>
                <td>16</td>
                <td>Ukraine</td>
            </tr>
            <tr class="tableRow">
                <td>2</td>
                <td>La Liga</td>
                <td>20</td>
                <td>Country</td>
            </tr>
            <tr class="tableRow">
                <td>3</td>
                <td>Premier League</td>
                <td>20</td>
                <td>England</td>
            </tr>
            <tr class="tableRow">
                <td>4</td>
                <td>Bundesliga</td>
                <td>18</td>
                <td>Germany</td>
            </tr>
            <tr class="tableRow">
                <td>5</td>
                <td>Serie A</td>
                <td>20</td>
                <td>Italy</td>
            </tr>
            <tr class="tableRow">
                <td>6</td>
                <td>Ligue 1</td>
                <td>20</td>
                <td>France</td>
            </tr>
            <tr class="tableRow">
                <td>7</td>
                <td>Primeira Liga</td>
                <td>16</td>
                <td>Portugal</td>
            </tr>
            <tr class="tableRow">
                <td>8</td>
                <td>Russian Football Premier League</td>
                <td>16</td>
                <td>Russia</td>
            </tr>
        </table>
    </section>
</div>
</body>
</html>