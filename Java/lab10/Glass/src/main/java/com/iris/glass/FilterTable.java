package com.iris.glass;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalTime;

import jakarta.servlet.http.HttpSession;
/*import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;*/
//@WebFilter(filterName = "FilterTable")
@WebFilter(urlPatterns = "/*")
public class FilterTable implements Filter {
  /*  static {
        new DOMConfigurator().doConfigure("C:\\instit\\kurs2-2\\Java\\lab10\\Glass\\src\\log4j.xml", LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(FilterTable.class);*/
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        chain.doFilter(request, response);
        MyData.isRegister = false;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURL().toString();

        String servletPath = httpRequest.getServletPath();
        String method = httpRequest.getMethod();
        String timeStamp = LocalTime.now().toString();
        String remoteAddress = request.getRemoteAddr();

       // LOG.info("Log: " +servletPath + method + timeStamp + remoteAddress);

        if (url.equals("http://localhost:8080/Glass-1.0-SNAPSHOT/ServletTable") && !MyData.isRegister) {
            request.setAttribute("name", "Нет авторизации для выполнения данной команды");
            HttpSession session = ((HttpServletRequest) request).getSession();
            session.setAttribute("loggedIn", false);
             RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
        chain.doFilter(request, response);

    }
}
