package com.example.glas1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Servlet6_a", value = "/Servlet6_a")
public class Servlet6_a extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");
        String redirectUrl = "http://localhost:8080/Glas1-1.0-SNAPSHOT/Servlet6_a2?param1=" + param1
                + "&param2=" + param2;

        response.sendRedirect(redirectUrl);

    }
}
