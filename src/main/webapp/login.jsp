<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You are logged in!</title>
</head>
<body>
    <h2> Hi ${user}!</h2>

    <form method="get" action="logout">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
