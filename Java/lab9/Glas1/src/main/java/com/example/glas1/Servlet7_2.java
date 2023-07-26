package com.example.glas1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet7_2", value = "/Servlet7_2")
public class Servlet7_2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramValue = request.getParameter("paramName");
        String responseText = "Received parameter value: " + paramValue;

        // Отправка ответа
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println(responseText);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
