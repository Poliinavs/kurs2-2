package com.iris.glass;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SecondServlet", value = "/SecondServlet")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String p1 = (String) request.getAttribute("param1");
        String p2 = (String) request.getAttribute("param2");

        try {
            writer.println("<h2>Параметр: " + p1 + "</h2>");
            writer.println("<h2>Параметр: " + p2 + "</h2>");
        } finally {
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}