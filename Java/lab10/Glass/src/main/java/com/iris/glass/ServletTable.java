package com.iris.glass;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletTable", value = "/ServletTable")
public class ServletTable extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Airport> airportList = retrieveData();
        for (var a:airportList
        ) {
            out.println(a.airplane);
        }
        request.setAttribute("myList", airportList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tabl.jsp");
        dispatcher.forward(request, response);
        /*List<String> myList = new ArrayList<String>();
        myList.add("Элемент 1");
        myList.add("Элемент 2");
        myList.add("Элемент 3");
        request.setAttribute("myList", myList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tabl.jsp");
        dispatcher.forward(request, response);*/

        // Pass data to JSP
        //  request.setAttribute("airportList", airportList);
        // request.getRequestDispatcher("tabl.jsp").forward(request, response);
    }
    private List<Airport> retrieveData() {

        List<Airport> airportList = new ArrayList<>();
        String connectionString = "jdbc:mysql://localhost:3306/Production?autoReconnect=true&useSSL=false";
        //////////////////////////////////
        try (Connection connection = DriverManager.getConnection(connectionString, "root", "1111")) {
            Statement statement = connection.createStatement();
            String sqlCommand = "SELECT\n" +
                    "  *\n" +
                    "FROM\n" +
                    "  airport\n";
            ResultSet resultset = statement.executeQuery(sqlCommand);


            while (resultset.next()) {
                String company = resultset.getString(1);
                String country = resultset.getString(2);
                String date = resultset.getString(3);
                Airport airport = new Airport(company,country,date);


                airportList.add(airport);


                  /*  inform="name:"+Name+" pass: "+ pass+" role: "+ role+" time: "+ LocalTime.now();
                out.print(inform);*/

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //////////////////////////////


        return airportList;
    }
    public class Airport {

        private String airplane;
        private String country;
        private String day;

        public Airport(String airplane, String country, String day) {
            this.airplane = airplane;
            this.country = country;
            this.day = day;
        }
        public String getField1() {
            return airplane;
        }
        public String getField2() {
            return country;
        }
        public String getField3() {
            return day;
        }
        // Getters and Setters

        //...
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

