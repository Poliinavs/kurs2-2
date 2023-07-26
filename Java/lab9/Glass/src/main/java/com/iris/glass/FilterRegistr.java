package com.iris.glass;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalTime;

//@WebFilter(filterName = "FilterRegistr", value = "/FilterRegistr")
@WebFilter(urlPatterns = "/AvtorFive")
public class FilterRegistr implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {

    }
    public Boolean first = false;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
     chain.doFilter(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

       // String connectionString = "jdbc:mysql://localhost:3306/avtoriz?autoReconnect=true&useSSL=false";
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
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            Statement statement = connection.createStatement();
            String sqlCommand = "SELECT\n" +
                    "  *\n" +
                    "FROM\n" +
                    "  avt\n";
            ResultSet resultset = statement.executeQuery(sqlCommand);
            out = response.getWriter();

            Boolean peopleIn=false;
            String inform="";
            while (resultset.next()) {
                String Name = resultset.getString(1);
                String pass = resultset.getString(2);
                String role = resultset.getString(3);

                if( Name.equals(login) && pass.equals(password)){
                    peopleIn=true;
                    inform="name:"+Name+" pass: "+ pass+" role: "+ role+" time: "+ LocalTime.now();
                }

            }
            if(peopleIn){
                out.print(inform);
            }
            else{
                if(first){
                    out.print("no");
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/EnterForm");
                }
                else{
                    first=true;
                }

              //  httpResponse.sendRedirect("/EnterForm");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
