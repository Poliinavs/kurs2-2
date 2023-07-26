package com.example.glas1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(name = "Servlet7_1", value = "/Servlet7_1")
public class Servlet7_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String paramValue = "Hello";
        String paramValue = getServletContext().getInitParameter("param1");
        // Формирование URL для GET-запроса к сервлету-два с передачей параметра
        String url = "http://localhost:8080/Glas1-1.0-SNAPSHOT/Servlet7_2?paramName=" + "Hellow";

        // Выполнение GET-запроса
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        // Получение ответа от сервлета-два
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer responseBuffer = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                responseBuffer.append(inputLine);
            }
            in.close();
            String responseText = responseBuffer.toString();

            // Вывод ответа на страницу Glassfish
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Response from ServletTwo:</h1>");
            out.println("<p>Parameter value: " + responseText + "</p>");
            out.println("</body></html>");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
