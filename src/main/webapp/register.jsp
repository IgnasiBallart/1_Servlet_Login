<%--
  Created by IntelliJ IDEA.
  User: iballart
  Date: 12/04/18
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Register</h1>
    <form method="post" action="register">
        User:<input type="text" name="user">
        Password:<input type="text" name="password">

        <input type="submit" value="Register">
    </form>
    <a href="index.jsp">
        <button>Back to login</button>
    </a>
</body>
</html>
