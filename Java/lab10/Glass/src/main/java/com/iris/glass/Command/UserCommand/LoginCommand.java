package com.iris.glass.Command.UserCommand;
import com.iris.glass.Command.Command;
import com.iris.glass.Command.CommandResult;
import com.iris.glass.Controller.Controller;
import com.iris.glass.Exepcions.StandartException;
import com.iris.glass.Model.MyData;
import com.iris.glass.Model.User;
import com.iris.glass.Model.aircompany;
import com.iris.glass.Pages.Page;
import com.iris.glass.Service.AirService;
import com.iris.glass.Service.PersonService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/*import org.testng.annotations.*;*/

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;

/*import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;*/
public class LoginCommand implements Command {
    String HI;

    private CommandResult loginError(HttpServletRequest request, String Error, String ERROR_MESSAGE)
    {
        request.setAttribute(Error, ERROR_MESSAGE);
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }

    private CommandResult login(HttpServletRequest request)
    {
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        String userLogin = request.getParameter("userLogin");
        String userPassword = request.getParameter("userPassword");

        User user = new User(userLogin,userPassword);
        List<aircompany> pr;
        try {
            if(PersonService.LogIn(user))
            {

                pr = AirService.GetProducts();

                request.setAttribute("myDataList", pr);
                request.setAttribute("name", MyData.ThisName);
                assertFalse(pr.isEmpty());


                return login(request);
            }
            else
            {
                return loginError(request,"Ошибка регистрации", "Что-то пошло не так..." );
            }
        } catch (StandartException e) {
            throw new RuntimeException(e);
        }

        /*String userLogin = request.getParameter("userLogin");
        String userPassword = request.getParameter("userPassword");
        InfAboutUser user = new InfAboutUser(userLogin, userPassword);

        if(PersonService.LogIn(user))
        {
            return login(request);
        }
        else {
            return loginError(request,"Ошибка регистрации", "Что-то пошло не так..." );
        }*/
    }

    @Override
    public CommandResult execute(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String userLogin = request.getParameter("userLogin");
        String userPassword = request.getParameter("userPassword");

        User user = new User(userLogin,userPassword);
        List<aircompany> pr;
        try {
            if(PersonService.LogIn(user))
            {

                pr = AirService.GetProducts();

                request.setAttribute("myDataList", pr);
                request.setAttribute("name", MyData.ThisName);
                assertFalse(pr.isEmpty());


                return login((HttpServletRequest) request);
            }
            else
            {
                return loginError((HttpServletRequest) request,"Ошибка регистрации", "Что-то пошло не так..." );
            }
        } catch (StandartException e) {
            throw new RuntimeException(e);
        }
    }
}
