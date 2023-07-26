package com.example.glas1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "Servlet6ab", value = "/Servlet6ab")
public class Servlet6ab extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/Servlet6ab_2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  response.sendRedirect(request.getContextPath() + "/Servlet6ab_2");
       /* ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/Servlet6ab_2");
        requestDispatcher.forward(request, response);*/
    }
}