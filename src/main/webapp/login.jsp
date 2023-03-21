<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <h1>Welcome to online shop</h1>
</div>
<div>
    <form method = "post">
        <label>
            <input placeholder="Enter you name" name = "NAME">
        </label>
        <br>
        <label>
            <input type="checkbox" name = "IS_AGREE" uncheked/>
        </label>
        I agree with terms of service
        <br>
        <button type="submit" formaction="http://localhost:8080/online-shop.com/login">Enter</button>
    </form>
</div>
</body>
</html>