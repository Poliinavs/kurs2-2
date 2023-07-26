package com.iris.glass;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Lab_9", value = "/Lab_9")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String protocol = request.getProtocol();
        String ipAddress = request.getRemoteAddr();
        String clientName = request.getRemoteHost();
        String method = request.getMethod();
        String url = request.getRequestURL().toString();
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();

        String queryString = request.getQueryString();

        PrintWriter out = response.getWriter();
        out.println("Time now: " + currentTime);
        out.println("Date now: " + currentDate);
        out.println("Protocol: " + protocol);
        out.println("IP Address: " + ipAddress);
        out.println("Client Name: " + clientName);
        out.println("Method: " + method);
        out.println("URL: " + url);
        out.println("Parametrs: " + queryString);
    }

    public void destroy() {
    }
}