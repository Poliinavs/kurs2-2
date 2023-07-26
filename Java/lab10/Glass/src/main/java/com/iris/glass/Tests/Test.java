package com.iris.glass.Tests;

import com.iris.glass.Model.User;
import com.iris.glass.Model.aircompany;
import com.iris.glass.Service.AirService;
import com.iris.glass.Service.PersonService;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.util.List;

import static org.testng.Assert.*;
import org.testng.Assert;
public class Test
{
    List<aircompany> aircompanyList;
    @BeforeMethod
    public void setUp() throws SQLException {
        aircompanyList= AirService.GetProducts();
    }

    @AfterSuite
    public void end()
    {
        System.out.println("Тест закончен!");
    }


    @org.testng.annotations.Test
    public void IsNotEmpty() {
        assertFalse(aircompanyList.isEmpty());
    }

    @org.testng.annotations.Test
    public void LoginUser() throws StandartException, com.iris.glass.Exepcions.StandartException {
        User user = new User("admin", "111");
        assertTrue(PersonService.LogIn(user));
    }

    @org.testng.annotations.Test
    public void LoginUserError() throws StandartException, com.iris.glass.Exepcions.StandartException {
        User user = new User("admin111", "admin12");
        assertFalse(PersonService.LogIn(user));
    }
}