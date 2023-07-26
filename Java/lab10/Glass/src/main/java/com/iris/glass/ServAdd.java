package com.iris.glass;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ServAdd", value = "/ServAdd")
public class ServAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String day = request.getParameter("day");
        String company = request.getParameter("compay");
        String country = request.getParameter("country");
        out.println(day);
        out.println(company);
        out.println(country);
        out.println("-------------------");
        //String connectionString = "jdbc:mysql://localhost:3306/avtoriz?autoReconnect=true&useSSL=false";
        String connectionString = "jdbc:mysql://localhost:3306/Production?autoReconnect=true&useSSL=false";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        // Connection connection = null;
        /*  if(a%2==0) {*/
        try (Connection connection = DriverManager.getConnection(connectionString, "root", "1111")) {
            ///////////


                    String insert = "INSERT INTO airport(airplane, county, day)  \n" + " VALUES(?,?,?)";

                    PreparedStatement stp = connection.prepareStatement(insert);


                    stp.setString(1, day);
                    stp.setString(2, company);
                    stp.setString(3, country);

                    stp.executeUpdate();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("ServletTable");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
