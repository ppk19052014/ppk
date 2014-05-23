<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="../public/style.css"/>
    <title></title>
</head>
<body class="body">
<header class="header">
    <div class="page_content-wrapper">

        <div class="header_user">
            <a href="../index.jsp" class="button">Sign out</a>
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
<div class="background">
    <section class="page">
        Hello Admin!
        <ul class="adminListAction">
            <li class="adminAction">
                <a href="mvc/addClub" >Add tournament page</a>
            </li>
            <li class="adminAction">
                <a href="mvc/addClub">Add club page</a>
            </li>
            <li class="adminAction">
                <a href="mvc/addPlayer">Add player page</a>
            </li>
        </ul>
    </section>
</div>

</body>
</html>