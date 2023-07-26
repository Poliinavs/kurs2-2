package com.iris.glass.Service;

import com.iris.glass.DataBase.Repository.RepositoryAir;
import com.iris.glass.Model.aircompany;

import java.sql.SQLException;
import java.util.List;

public class AirService {
    public static List<aircompany> GetProducts() throws SQLException {
        return RepositoryAir.getAllproducts();
    }

   public static boolean AddProduct(aircompany product)
    {
        try{
            RepositoryAir.AddAirComp(product);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    public static boolean removeAir(String name)
    {
        try{
            RepositoryAir.RemoveAir(name);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}