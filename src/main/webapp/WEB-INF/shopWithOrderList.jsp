<%@ page import="java.util.ArrayList" %>
<%@ page import="com.training.model.Cart" %>
<%@ page import="com.training.service.CartService" %>
<%@ page import="com.training.service.service_impl.CartServiceImpl" %>
<%@ page import="com.training.model.Good" %>
<%@ page import="com.training.service.service_impl.GoodServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.training.service.GoodService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
</head>
<body>
<div>
    <h1>Hello <%= session.getAttribute("NAME") %> !</h1>
    <p>You have already chosen:</p>
</div>
<div>
    <%
        String items = (String) session.getAttribute("CHOSEN_GOODS");
    %>
    <%=items%>
</div>
<div>
    <form method="post" id="orderForm">
        <select name="ITEM">
            <%  GoodService service = new GoodServiceImpl();
                List<Good> goods = service.getListGoods();
                StringBuilder items_list = new StringBuilder();
                for (Good el : goods) {
                    items_list.append("<option>" + el.getTitle() + " (" + el.getPrice() + "$) </option>\n");
                }
            %>
            <%=
            items_list
            %>
        </select>
        <button type="submit" formaction="http://localhost:8080/online-shop.com/shop">Enter</button>
        <button type="submit" formaction="http://localhost:8080/online-shop.com/order">Order</button>
    </form>
</div>
</body>
</html>