package com.training.servlets;

import com.training.model.Cart;
import com.training.model.Good;
import com.training.service.CartService;
import com.training.service.service_impl.CartServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "shop",
        urlPatterns = "/shop"
)

public class ShopServlet extends HttpServlet {
    private static final String ATTRIBUTE_CART = "CART";
    private static final String ATTRIBUTE_TOTAL_PRICE = "TOTAL_PRICE";
    private static final String ATTRIBUTE_CHOSEN_GOODS = "CHOSEN_GOODS";
    private static final String PARAM_ITEM = "ITEM";
    private static final String SHOP_WITH_ORDER_PAGE = "WEB-INF/shopWithOrderList.jsp";
    private static final String SHOP_PAGE = "WEB-INF/shop.jsp";
    private static final String REGEX_ONLY_LETTERS = "[^A-Za-z]";
    private static final String REGEX_ONLY_PRICE = ".*\\(|\\$.*";
    private static final String REGEX_FOR_DOUBLE_VALUE = ",";
    private CartService cartService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(SHOP_PAGE);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        cartService = new CartServiceImpl();
        createCart(session);

        Cart cart = (Cart) session.getAttribute(ATTRIBUTE_CART);
        String item = req.getParameter(PARAM_ITEM);
        addGoodToCart(item, cart);

        session.setAttribute(ATTRIBUTE_TOTAL_PRICE, cartService.getTotalPrice(cart));
        session.setAttribute(ATTRIBUTE_CHOSEN_GOODS, cartService.print(cart));
        RequestDispatcher dispatcher = req.getRequestDispatcher(SHOP_WITH_ORDER_PAGE);
        dispatcher.forward(req, resp);
    }

    private void createCart(HttpSession session) {
        if (session.getAttribute(ATTRIBUTE_CART) == null) {
            session.setAttribute(ATTRIBUTE_CART, new Cart());
        }
    }

    private void addGoodToCart(String selectedGood, Cart cart) {
        String name = selectedGood.replaceAll(REGEX_ONLY_LETTERS, "");
        String price = selectedGood.replaceAll(REGEX_ONLY_PRICE, "");
        double coast = Double.parseDouble(price.replaceAll(REGEX_FOR_DOUBLE_VALUE, "."));
        cart.addGoods(new Good(name, coast));
    }

}
