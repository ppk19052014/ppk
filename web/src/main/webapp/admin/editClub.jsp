<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <label><input type="text" name="id" value="${editClub.id}" style="display:none;"></label>
                <label><input type="text" name="name" value="${editClub.name}"/></label>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Edit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
