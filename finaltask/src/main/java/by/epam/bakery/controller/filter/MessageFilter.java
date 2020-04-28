package by.epam.bakery.controller.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MessageFilter implements Filter {
    private static final String RIGHT = "right";
    private static final String WRONG = "wrong";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        String rightMessage = (String) session.getAttribute(RIGHT);
        String wrongMessage = (String) session.getAttribute(WRONG);
        if (rightMessage != null) {
            req.setAttribute(RIGHT, rightMessage);
            session.setAttribute(RIGHT, null);
        }
        if(wrongMessage != null) {
            req.setAttribute(WRONG, wrongMessage);
            session.setAttribute(WRONG, null);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
