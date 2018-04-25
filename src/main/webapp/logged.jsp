<%--
  Created by IntelliJ IDEA.
  User: iballart
  Date: 25/04/18
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logged</title>
</head>
<body>
    <h2> Hi ${user}! You are logged!</h2>
    <form method="get" action="logout">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
