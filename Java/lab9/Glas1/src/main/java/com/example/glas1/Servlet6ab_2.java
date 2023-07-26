package com.example.glas1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet6ab_2", value = "/Servlet6ab_2")
public class Servlet6ab_2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("CorrectWork.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //  request.getRequestDispatcher("CorrectWork.jsp").forward(request, response);
     /*   String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");

        request.setAttribute("param1", param1);
        request.setAttribute("param2", param2);
        String p = getServletContext().getInitParameter("userParam");
        request.setAttribute("param3", p);
        // Перенаправляем на JSP-страницу
        request.getRequestDispatcher("/index.jsp").forward(request, response);*/
    }
}
