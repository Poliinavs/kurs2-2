package com.example.glas1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet6_a2", value = "/Servlet6_a2")
public class Servlet6_a2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Second Servlet</title></head><body>");
        out.println("<h1>Param 1: " + param1 + "</h1>");
        out.println("<h1>Param 2: " + param2 + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");

        // Отправка параметров в виде HTML-страницы клиенту
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Redirected Page</h1>");
        out.println("<p>Param1: " + param1 + "</p>");
        out.println("<p>Param2: " + param2 + "</p>");
        out.println("</body>");
        out.println("</html>");*/
    }
}
