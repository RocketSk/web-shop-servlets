package com.training.servlets;

import com.training.model.Order;
import com.training.model.User;
import com.training.service.OrderService;
import com.training.service.UserService;
import com.training.service.service_impl.OrderServiceImpl;
import com.training.service.service_impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "order",
        urlPatterns = "/order"
)

public class OrderServlet extends HttpServlet {

    private static final String ORDER_PAGE = "WEB-INF/order.jsp";
    private static final String ATTRIBUTE_NAME = "NAME";
    private static final String ATTRIBUTE_TOTAL_PRICE = "TOTAL_PRICE";
    private OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Order newOrder = createOrder(session);
        orderService.addOrder(newOrder);

        RequestDispatcher dispatcher = req.getRequestDispatcher(ORDER_PAGE);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private Order createOrder(HttpSession session) {
        Order order = new Order();
        UserService userService = new UserServiceImpl();
        orderService = new OrderServiceImpl();
        double totalPrice = (Double) session.getAttribute(ATTRIBUTE_TOTAL_PRICE);

        String userLogin = (String) session.getAttribute(ATTRIBUTE_NAME);
        User user = userService.getUserByLogin(userLogin);
        int orderId = orderService.getListOrders().size() + 1;

        order.setId(orderId);
        order.setUserId(user.getId());
        order.setTotalPrice(totalPrice);

        System.out.println(order);
        return order;
    }
}