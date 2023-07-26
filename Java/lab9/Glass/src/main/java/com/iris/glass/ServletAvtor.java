package com.iris.glass;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ServletAvtor", value = "/ServletAvtor")
public class ServletAvtor extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    public Connection dbConnection;
    public static Statement statement;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
       String connectionString="jdbc:mysql://localhost:3306/Production?autoReconnect=true&useSSL=false";
       // String connectionString = "jdbc:mysql://localhost:3306/Production?autoReconnect=true&useSSL=false";
    Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                "root","1111" );
        statement = dbConnection.createStatement();
        dbConnection.setAutoCommit(false);

        dbConnection.setAutoCommit(false);
        return dbConnection;
    }
    public void Product() throws SQLException, IOException {
        ServletResponse response = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("SQLWORK: " );
        String sqlCommand = "SELECT\n" +
                "  *\n" +
                "FROM\n" +
                "  product\n" +
                "WHERE\n" +
                "  param NOT LIKE '%камера%'";
        ResultSet resultset = statement.executeQuery(sqlCommand);
        out.printf("--------------Вывести перечень продукции, не содержащий заданного параметра----------");

        while (resultset.next()) {
            String Group = resultset.getString(1);
           out.print("\nгруппа продукции: " + Group);

        }
        dbConnection.commit();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

 /* try {
            this.getDbConnection();
            this.Product();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

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
        try (Connection connection = DriverManager.getConnection(connectionString, "root", "1111")) {
            Statement statement = connection.createStatement();
            String sqlCommand = "SELECT\n" +
                    "  *\n" +
                    "FROM\n" +
                    "  product\n";
            ResultSet resultset = statement.executeQuery(sqlCommand);
            PrintWriter out = response.getWriter();
            out.println("SQLWORK: " );
            out.printf("--------------Вывести перечень продукции, не содержащий заданного параметра----------");

            while (resultset.next()) {
                String Group = resultset.getString(1);
                out.print( Group);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        response.setContentType("text/html");


        PrintWriter out = response.getWriter();
        out.println("Time now: " );

    }

    public void destroy() {
    }
}
