package com.iris.glass.Controller;

import com.iris.glass.Command.Command;
import com.iris.glass.Command.CommandFactory;
import com.iris.glass.Command.CommandResult;
import com.iris.glass.Connection.ConnectionPool;
import com.iris.glass.Model.MyData;
import com.iris.glass.Pages.Page;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalTime;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {
    private static final String COMMAND = "command";
    private static final String ERROR_MESSAGE = "error_message";
    public static final Logger LOG = Logger.getLogger(Controller.class);
    static {
        new DOMConfigurator().doConfigure("C:/instit/kurs2-2/Java/lab10/Glass/src/main/java/com/iris/glass/Log/log4j.xml", LogManager.getLoggerRepository());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyData.isRegister = false;

          processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String command = request.getParameter(COMMAND);


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();



        //Logger
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String servletPath = httpRequest.getServletPath();
        String method = httpRequest.getMethod();
        String timeStamp = LocalTime.now().toString();
        String remoteAddress = request.getRemoteAddr();

       LOG.info("Log: " +servletPath + method + timeStamp + remoteAddress + "Command:" + command);
        out.println("Log: " +servletPath + method + timeStamp + remoteAddress + "Command:" + command);
        //end Logger

       Command action = CommandFactory.create(command);
        CommandResult commandResult;
        try {

            commandResult = action.execute(request, response);

        }
        catch (Exception ex)
        {

            request.setAttribute("name", ex.getMessage());
            commandResult = new CommandResult(Page.WELCOME_PAGE.getPage(), false);
        }
        String page = commandResult.getPage();


        if(commandResult.isRedirect())
        {
            sendDirect(response, page);
        }
        else
        {
            dispatch(request, response, page);
        }
    }
    private void sendDirect(HttpServletResponse response, String page) throws IOException {
        response.sendRedirect(page);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(page);
       /* RequestDispatcher dispatcher = request.getRequestDispatcher("ServletTable");
        dispatcher.forward(request, response);*/
        requestDispatcher.forward(request, response);
    }



    @Override
    public void init()
    {
        ConnectionPool.getInstance();
    }
    @Override
    public void destroy()
    {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            connectionPool.destroy();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
