package com.iris.glass.Command.UserCommand;

import com.iris.glass.Command.Command;
import com.iris.glass.Command.CommandResult;
import com.iris.glass.Controller.Controller;
import com.iris.glass.Exepcions.StandartException;
import com.iris.glass.Model.aircompany;
import com.iris.glass.Pages.Page;
import com.iris.glass.Service.AirService;
import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.iris.glass.*;

public class AddAirComp implements Command {
    private CommandResult addTeamError(HttpServletRequest request, String Error, String ERROR_MESSAGE)
    {
        Controller.LOG.info("FALSE ");
        request.setAttribute(Error, ERROR_MESSAGE);
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
    private CommandResult addTeam(HttpServletRequest request)
    {
        Controller.LOG.info("TRUE ");

        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }



    @Override
    public CommandResult execute(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, StandartException {
        String day = request.getParameter("day");
        String company = request.getParameter("compay");
        String country = request.getParameter("country");

        aircompany product = new aircompany(company, country, day);

        if(AirService.AddProduct(product))
        {
            List<aircompany> productsList = AirService.GetProducts();
            request.setAttribute("myDataList", productsList);
            request.setAttribute("name", true);
            Controller.LOG.info("TdddRUE ");
            return addTeam((HttpServletRequest) request);
        }
        else {
            request.setAttribute("name", "Ошибка при добавлении");
            return addTeamError((HttpServletRequest) request,"Ошибка регистрации", "Что-то пошло не так..." );
        }
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String day = request.getParameter("day");
        String company = request.getParameter("compay");
        String country = request.getParameter("country");

        aircompany product = new aircompany(company, country, day);

        if(AirService.AddProduct(product))
        {
            List<aircompany> productsList = AirService.GetProducts();
            request.setAttribute("myDataList", productsList);
            request.setAttribute("name", true);
            Controller.LOG.info("TdddRUE ");
            return addTeam((HttpServletRequest) request);
        }
        else {
            request.setAttribute("name", "Ошибка при добавлении");
            return addTeamError((HttpServletRequest) request,"Ошибка регистрации", "Что-то пошло не так..." );
        }
    }
}