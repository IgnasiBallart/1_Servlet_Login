<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Register</h1>
    <form method="post" action="register">
        User:<input type="text" name="user" required>
        Password:<input type="password" name="password" required>
        <input type="submit" value="Register">
    </form>
    ${errorMessage}
    <br/>
    <a href="/">
        <button>Back</button>
    </a>
</body>
</html>
