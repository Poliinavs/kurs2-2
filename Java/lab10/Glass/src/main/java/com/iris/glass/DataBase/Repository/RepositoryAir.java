package com.iris.glass.DataBase.Repository;

import com.iris.glass.Connection.ConnectionPool;
import com.iris.glass.Controller.Controller;
import com.iris.glass.Model.aircompany;
import com.iris.glass.ServletTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryAir {
    public static List<aircompany> getAllproducts() throws SQLException {

        ////////////////
        List<aircompany> airportList = new ArrayList<>();
        ConnectionPool connection = ConnectionPool.getInstance();
        Statement statement = connection.GetConnectionString().createStatement();

            String sqlCommand = "SELECT\n" +
                    "  *\n" +
                    "FROM\n" +
                    "  airport\n";
            ResultSet resultset = statement.executeQuery(sqlCommand);


            while (resultset.next()) {



                String company = resultset.getString(1);
                String country = resultset.getString(2);
                String date = resultset.getString(3);

                aircompany airport = new aircompany(company,country,date);
                airportList.add(airport);

            }


        return airportList;
    }

   public static boolean RemoveAir(String name) throws SQLException {
       Controller.LOG.info("INFUNCREmove");
       ConnectionPool connection = ConnectionPool.getInstance();

       String sql = "DELETE FROM airport WHERE airplane = ?";

           PreparedStatement preparedStatement = connection.GetConnectionString().prepareStatement(sql);
           preparedStatement.setString(1, name);

           int rowsAffected = preparedStatement.executeUpdate();


           if (rowsAffected > 0) {
               Controller.LOG.info("Dell");
               return true;
           } else {
               Controller.LOG.info("NoDell");
               return false;
           }





   }

    public static boolean AddAirComp(aircompany air) throws SQLException {


        String insert = "INSERT INTO airport(airplane, county, day)  \n" + " VALUES(?,?,?)";

        ConnectionPool connection = ConnectionPool.getInstance();
        PreparedStatement stp = connection.GetConnectionString().prepareStatement(insert);


        stp.setString(1, air.day);
        stp.setString(2, air.airplane);
        stp.setString(3, air.country);

        int rowsAffected=   stp.executeUpdate();

            if (rowsAffected > 0)
            {
                Controller.LOG.info("Addd");
                return true;
            }

            else
            {
                Controller.LOG.info("Addd no");
                return false;
            }


        }

    }

