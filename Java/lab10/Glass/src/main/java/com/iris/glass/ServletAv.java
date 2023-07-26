package com.iris.glass;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalTime;

@WebServlet(name = "ServletAv", value = "/ServletAv")

public class ServletAv extends HttpServlet {
    private Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
            return null;
        }
        return null;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String login = request.getParameter("login");
        String password = request.getParameter("password");

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
                    "  avt\n";
            ResultSet resultset = statement.executeQuery(sqlCommand);
            out = response.getWriter();
            out.println("try: " );

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
            if(peopleIn && inform!=""){
                MyData.isRegister=true;
                RequestDispatcher dispatcher = request.getRequestDispatcher("ServletTable");
                dispatcher.forward(request, response);
               /* out.print(inform);
                ///////////////////////////////
                //ФАЙЛЫ cookie

                // Получаем объект Cookie для последнего сеанса пользователя
                Cookie lastVisitCookie = getCookie(request, "lastVisit"+login+password);

                // Получаем текущую дату и время
                LocalTime time2 = LocalTime.now();
                String currentDateTime = time2.toString();

                // Получаем количество посещений из Cookie
                int visitCount = 1;
                Cookie visitCountCookie = getCookie(request, "visitCount"+login+password);
                if (visitCountCookie != null) {
                    try {
                        visitCount = Integer.parseInt(visitCountCookie.getValue());
                        visitCount++;
                    } catch (NumberFormatException e) {

                    }
                }



                // Создаем Cookie для даты последнего посещения
                Cookie newLastVisitCookie = new Cookie("lastVisit"+login+password, currentDateTime);
                newLastVisitCookie.setMaxAge(150 * 60 * 60); // время жизни Cookie - 150 часов

                // Создаем Cookie для количества посещений
                Cookie newVisitCountCookie = new Cookie("visitCount"+login+password, String.valueOf(visitCount));
                newVisitCountCookie.setMaxAge(150 * 60 * 60);

                // Создаем Cookie для типа пользователя
                Cookie newTypeOfUserCookie = new Cookie("userType", "user");
                newTypeOfUserCookie.setMaxAge(150 * 60 * 60);

                // Добавляем созданные Cookie в объект HttpServletResponse
                response.addCookie(newLastVisitCookie);
                response.addCookie(newVisitCountCookie);
                response.addCookie(newTypeOfUserCookie);

                // Выводим результат пользователю
                response.setContentType("text/html");

                out.println("<h1>HellowUser</h1>");
                if (lastVisitCookie != null) {
                    out.println("<p>You last visit " + lastVisitCookie.getValue() + "</p>");
                }
                out.println("<p>Visit count " + visitCount + " times</p>");
                out.println("</body></html>");*/
                /////////////////////////
            }
            else{
                out.print("no");
                response.sendRedirect("index.jsp?error=true");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        System.out.println("Логин: " + login);
        System.out.println("Пароль: " + password);
    }
}
