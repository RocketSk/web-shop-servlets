package com.training.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.training.servlets.*;

@WebFilter(
        filterName = "loginFilter",
        urlPatterns = {"/shop", "/order"}
)
public class AuthFilter implements Filter {
    private static final String ATTRIBUTE_LOGIN = "IS_LOGIN";
    final String ERROR_PAGE = "http://localhost:8080/online-shop.com/disagreed";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (session.getAttribute(ATTRIBUTE_LOGIN) == null) {
            response.sendRedirect(ERROR_PAGE);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}