package com.training.servlets;

import com.training.model.User;
import com.training.service.UserService;
import com.training.service.service_impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(
        name = "loginServlet",
        urlPatterns = "/login")

public class LoginServlet extends HttpServlet {
    private static final String PARAM_NAME = "NAME";
    private static final String PARAM_USER = "USER";
    private static final String ATTRIBUTE_LOGIN = "IS_LOGIN";
    private static final String PARAM_AGREE = "IS_AGREE";
    private User user;
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processLogin(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void processLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        if (req.getParameter(PARAM_AGREE) != null) {
            HttpSession session = req.getSession(true);
            userService = new UserServiceImpl();
            User user = createNewUser(req, userService);
            userService.addUser(user);
            session.setAttribute(PARAM_USER, user);
            session.setAttribute(PARAM_NAME, user.getUsername());
            session.setAttribute(ATTRIBUTE_LOGIN, "on");
        }
        resp.sendRedirect(req.getContextPath() + "/shop");
    }

    private User createNewUser(HttpServletRequest request, UserService userService) {
        user = new User();
        String userName = request.getParameter(PARAM_NAME);
        user.setUsername(userName);
        int userId = userService.getAllUsers().size();
        user.setId(userId + 1);
        return user;
    }
}