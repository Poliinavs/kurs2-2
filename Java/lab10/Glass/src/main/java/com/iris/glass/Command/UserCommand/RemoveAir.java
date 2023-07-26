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

public class RemoveAir implements Command {
    private CommandResult RemoveTeamError(HttpServletRequest request, String Error, String ERROR_MESSAGE)
    {
        request.setAttribute(Error, ERROR_MESSAGE);
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
    private CommandResult removeTeam(HttpServletRequest request)
    {
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }

    @Override
    public CommandResult execute(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, StandartException {
        Controller.LOG.info("InRemove");
        String name = request.getParameter("name");

        if(AirService.removeAir(name))
        {

            List<aircompany> productsList = AirService.GetProducts();
            request.setAttribute("myDataList", productsList);
            request.setAttribute("name",true);
            return removeTeam((HttpServletRequest) request);
        }
        else
        {
            List<aircompany> productsList = AirService.GetProducts();
            request.setAttribute("myDataList", productsList);
            request.setAttribute("name",true);
            return removeTeam((HttpServletRequest) request);
        }
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String company = request.getParameter("comp");

        if(AirService.removeAir(company))
        {
            List<aircompany> productsList = AirService.GetProducts();
            request.setAttribute("myDataList", productsList);
            request.setAttribute("name",true);
            return removeTeam((HttpServletRequest) request);
        }
        else
        {
            List<aircompany> productsList = AirService.GetProducts();
            request.setAttribute("myDataList", productsList);
            request.setAttribute("name",true);
            return removeTeam((HttpServletRequest) request);
        }
    }


}