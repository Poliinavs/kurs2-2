package com.iris.glass;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(name = "AvtorFive", value = "/AvtorFive")
public class ServletAvotorFive extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //вывод инфы
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<form>");

        out.println("<head>");
        out.println("<title>My Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"/secure/some-page\">");
        out.println(" <label for=\"login\">Логин:</label>\n" +
                "    <input type=\"text\" id=\"login\" name=\"login\"><br>\n" +
                "    <label for=\"password\">Пароль:</label>\n" +
                "    <input type=\"password\" id=\"password\" name=\"password\"><br>\n" +
                "    <input type=\"submit\" value=\"Войти\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</form>");


    }

    public void destroy() {
    }
}