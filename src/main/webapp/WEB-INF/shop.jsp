<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
</head>
<body>
<div>
    <h1>Hello <%= session.getAttribute("NAME") %> !</h1>
    <p>Make you order:</p>
</div>
<div>
    <form method="post" id="orderForm">
        <select name="ITEM">
            <option>Book (15,00$)</option>
            <option>Phone (450,00$)</option>
            <option>IPhone (1450,00$)</option>
            <option>Phone case (3,00$)</option>
            <option>IPhone case (10,83$)</option>
            <option>TV (300,23$)</option>
        </select>
        <button type="submit" formaction="http://localhost:8080/online-shop.com/shop">Enter</button>
        <button type="submit" formaction="http://localhost:8080/online-shop.com/shop">Order</button>
    </form>
</div>
</body>
</html>
