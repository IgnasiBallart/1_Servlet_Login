<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You are logged in!</title>
</head>
<body>
    <h1>Login</h1>
    <form method="post" action="login">
        User:<input type="text" name="user">
        Password:<input type="password" name="password">

        <input type="submit" value="Log in">
    </form>
    <a href="index.jsp">
        <button>Back</button>
    </a>
</body>
</html>
