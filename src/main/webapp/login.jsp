<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login!</title>
</head>
<body>
    <h1>Login</h1>
    <form method="post" action="login">
        User:<input type="text" name="user" required>
        Password:<input type="password" name="password" required>
        <input type="submit" value="Log in">
    </form>
    ${errorMessage}
    <br/>
    <a href="/">
        <button>Back</button>
    </a>
</body>
</html>
