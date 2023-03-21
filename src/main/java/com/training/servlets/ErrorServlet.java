package com.training.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "authError",
        urlPatterns = "/disagreed"
)
public class ErrorServlet extends HttpServlet {
    final private static String ERROR_PAGE = "/WEB-INF/authError.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(ERROR_PAGE);
        dispatcher.forward(req, resp);
    }
}
