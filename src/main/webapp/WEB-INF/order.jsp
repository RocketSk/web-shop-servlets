<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<div>
    <h1>Dear <%=session.getAttribute("NAME")%>, your order:</h1>
</div>
<div>
    <p>
        <%
            String items = (String) session.getAttribute("CHOSEN_GOODS");
        %>
        <%=items%>
    </p>
    <p>
        <%
            double total = (Double) session.getAttribute("TOTAL_PRICE");
        %>
        Total: $ <%=total%>
    </p>
</div>
</body>
</html>