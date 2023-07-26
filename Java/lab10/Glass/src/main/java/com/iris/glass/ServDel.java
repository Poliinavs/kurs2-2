package com.iris.glass;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "ServDel", value = "/ServDel")
public class ServDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String company = request.getParameter("comp");


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
            String sql = "DELETE FROM airport WHERE airplane = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, company);
                preparedStatement.executeUpdate();
                System.out.println("Строка успешно удалена из базы данных.");
            } catch (SQLException e) {
                e.printStackTrace();
            }




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
