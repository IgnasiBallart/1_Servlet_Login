<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2> Hi ${user}! You are logged!</h2>
    <form method="get" action="/logout">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
