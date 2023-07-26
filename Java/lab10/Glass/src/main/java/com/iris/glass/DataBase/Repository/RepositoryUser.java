package com.iris.glass.DataBase.Repository;

import com.iris.glass.Connection.ConnectionPool;
import com.iris.glass.Controller.Controller;
import com.iris.glass.Model.MyData;

import java.sql.*;

public class RepositoryUser {
    public static boolean AddUserToDb(String login, String password)
    {

        String sql2 = "insert into avt(name, pass)\n" +
                "values\n" +
                "(?,?);";
        ConnectionPool connection = ConnectionPool.getInstance();
        try (PreparedStatement statement = connection.GetConnectionString().prepareStatement(sql2)) {
            statement.setString(1, login);
            statement.setString(2, password);
            int rowsAffected = statement.executeUpdate();


            if (rowsAffected > 0) {

                return true;
            }

            else if(rowsAffected == 0) {
                return false;
            }


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean LogInUser(String login, String password) throws SQLException {


        String sqlCommand = "SELECT\n" +
                "  *\n" +
                "FROM\n" +
                "  avt\n";
        ConnectionPool connection = ConnectionPool.getInstance();
        Statement statement = connection.GetConnectionString().createStatement();
        ResultSet resultset = statement.executeQuery(sqlCommand);

        Boolean samePeople=false;

        while (resultset.next()) {
            String Name = resultset.getString(1);
            String pass = resultset.getString(2);

            if( Name.equals(login) && pass.equals(password)){
                samePeople=true;

            }

        }
        if(samePeople){

            return true;
        }
        else{

            return false;

        }


    }

}
