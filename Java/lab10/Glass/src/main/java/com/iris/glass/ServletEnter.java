package com.iris.glass;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalTime;

@WebServlet(name = "EnterForm", value = "/EnterForm")
public class ServletEnter extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    public int a=1;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //вывод инфы
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /*out.println("<form>");

        out.println("<head>");
        out.println("<title>My Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(" <label for=\"login\">Логин:</label>\n" +
                "    <input type=\"text\" id=\"login\"  value=\"login\" name=\"login\"><br>\n" +
                "    <label for=\"password\">Пароль:</label>\n" +
                "    <input type=\"password\" value=\"pass\"  id=\"password\" name=\"password\"><br>\n" +
                "    <input type=\"submit\" value=\"Регистрация\">");
        out.println("</body>");
        out.println("</form>");*/
        ///


        String login = request.getParameter("login");
        String password = request.getParameter("password");
       out.println(login);
        out.println(password);
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
                Statement statement = connection.createStatement();
                String sqlCommand = "SELECT\n" +
                        "  *\n" +
                        "FROM\n" +
                        "  avt\n";
                ResultSet resultset = statement.executeQuery(sqlCommand);
                out = response.getWriter();

                Boolean samePeople=false;

                while (resultset.next()) {
                    String Name = resultset.getString(1);
                    if( Name.equals(login) ){
                        samePeople=true;

                    }

                }
                /////////////////
                if(login=="login"||password=="pass"|| login==""||password==""){

                    samePeople=true;
                }
                if(samePeople){
                    response.sendRedirect("reg.jsp?error=true");
                }
                else{
                    MyData.isRegister=true;
                    String insert = "INSERT INTO avt(name, pass, role) \n" + " VALUES(?,?,?)";

                    PreparedStatement stp = connection.prepareStatement(insert);


                    stp.setString(1, login);
                    stp.setString(2, password);
                    stp.setString(3, "user");

                    stp.executeUpdate();}

                RequestDispatcher dispatcher = request.getRequestDispatcher("ServletTable");
                dispatcher.forward(request, response);


            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
       /* }
        else{
            a++;
        }*/
        ////


        /*System.out.println(insert);
        LOG.info(insert);*/



    }

    public void destroy() {
    }
}