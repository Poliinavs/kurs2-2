package com.iris.glass.Command.UserCommand;

import com.iris.glass.Command.Command;
import com.iris.glass.Command.CommandResult;
import com.iris.glass.Controller.Controller;
import com.iris.glass.Exepcions.StandartException;
import com.iris.glass.Model.User;
import com.iris.glass.Model.aircompany;
import com.iris.glass.Pages.Page;
import com.iris.glass.Service.AirService;
import com.iris.glass.Service.PersonService;
import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RegistrNewUserCommand implements Command {
    private CommandResult registerError(HttpServletRequest request, String Error, String ERROR_MESSAGE)
    {
        request.setAttribute(Error, ERROR_MESSAGE);
        Controller.LOG.info("FALSE ");
        return new CommandResult(Page.REGISTER_PAGE.getPage(), false);
    }
    private CommandResult register()
    {
      Controller.LOG.info("TRUE ");

        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }


    @Override
    public CommandResult execute(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, StandartException {
        String userLogin = request.getParameter("userLogin");
        String userPassword = request.getParameter("userPassword");
        User user = new User(userLogin,userPassword);


        try {
            if(!PersonService.LogIn(user))
            {
                User user2 = new User(userLogin, userPassword);

                if (PersonService.addPerson(user2)) {
                    Controller.LOG.info("TdddRUE ");
                    List<aircompany> productsList = AirService.GetProducts();
                    request.setAttribute("myDataList", productsList);
                    request.setAttribute("name",true);
                    return register();
                } else {

                    return registerError((HttpServletRequest) request, "Ошибка регистрации", "Что-то пошло не так...");
                }

            }
            else
            {
                return registerError((HttpServletRequest) request,"Ошибка регистрации", "Что-то пошло не так..." );
            }
        } catch (StandartException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String userLogin = request.getParameter("userLogin");
        String userPassword = request.getParameter("userPassword");
        User user = new User(userLogin,userPassword);


        try {
            if(!PersonService.LogIn(user))
            {
                User user2 = new User(userLogin, userPassword);

                if (PersonService.addPerson(user2)) {
                    Controller.LOG.info("TdddRUE ");
                    List<aircompany> productsList = AirService.GetProducts();
                    request.setAttribute("myDataList", productsList);
                    request.setAttribute("name",true);
                    return register();
                } else {

                    return registerError((HttpServletRequest) request, "Ошибка регистрации", "Что-то пошло не так...");
                }

            }
            else
            {
                return registerError((HttpServletRequest) request,"Ошибка регистрации", "Что-то пошло не так..." );
            }
        } catch (StandartException e) {
            throw new RuntimeException(e);
        }
    }
}