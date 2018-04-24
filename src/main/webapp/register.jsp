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
