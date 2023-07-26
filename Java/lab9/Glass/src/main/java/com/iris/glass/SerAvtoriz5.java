package com.iris.glass;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SerAvtoriz", value = "/SerAvtoriz")
public class SerAvtoriz5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = "<h1>Hello, World!</h1>";

        // Устанавливаем MIME-тип и кодировку ответа
        response.setContentType("text/html;charset=UTF-8");

        // Получаем объект PrintWriter для записи контента в ответ
        PrintWriter out = response.getWriter();

        // Вставляем контент на страницу
        out.println("<html>");
        out.println("<head>");
        out.println("<title>My Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id=\"content\">" + content + "</div>");
        out.println("</body>");
        out.println("</html>");
     /*   response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<form>");

        out.println("<head>");
        out.println("<title>My Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(" <label for=\"login\">Логин:</label>\n" +
                "    <input type=\"text\" id=\"login\" name=\"login\"><br>\n" +
                "    <label for=\"password\">Пароль:</label>\n" +
                "    <input type=\"password\" id=\"password\" name=\"password\"><br>\n" +
                "    <input type=\"submit\" value=\"Войти\">");
        out.println("</body>");
        out.println("</form>");*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
