<%--
  Created by IntelliJ IDEA.
  User: iballart
  Date: 12/04/18
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form method="post" action="login">
        User:<input type="text" name="user">
        Password:<input type="text" name="password">

        <input type="submit" value="Login">
    </form>
    <a href="register.jsp">
        <button>Register</button>
    </a>
</body>
</html>
