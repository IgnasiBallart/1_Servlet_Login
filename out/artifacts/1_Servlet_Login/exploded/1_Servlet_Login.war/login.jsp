<%--
  Created by IntelliJ IDEA.
  User: iballart
  Date: 12/04/18
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
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
