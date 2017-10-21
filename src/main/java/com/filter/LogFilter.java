package com.filter;

import com.wrappers.CopyrightResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/input.jsp","/result.jsp"})
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        CopyrightResponseWrapper wrapper =
                new CopyrightResponseWrapper( (HttpServletResponse)response );
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("username");
        if (user == null) {
            request.setAttribute("name", "You are not logged in");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else{
            filterChain.doFilter(servletRequest,wrapper);
            String content = wrapper.toString();
            StringWriter sw = new StringWriter();
            sw.write(content.substring(1));
            sw.write("<h1>Thank you !</h1>");
            PrintWriter out = servletResponse.getWriter();
            out.write(sw.toString());
        }

    }

    @Override
    public void destroy() {

    }
}
