package com.iris.glass.Command;

import com.iris.glass.Command.UserCommand.AddAirComp;
import com.iris.glass.Command.UserCommand.LoginCommand;
import com.iris.glass.Command.UserCommand.RegistrNewUserCommand;
import com.iris.glass.Command.UserCommand.RemoveAir;
import com.iris.glass.Controller.Controller;

public class CommandFactory {
    public static Command create(String command)
    {
        command = command.toUpperCase();
        System.out.println(command);
      CommandType commandEnum = CommandType.valueOf(command);
        Command resultCommand = new LoginCommand();

        switch (commandEnum)
        {
            case LOGIN:
                resultCommand = new LoginCommand();
                break;
          case REGISTER:
                resultCommand = new RegistrNewUserCommand();
              Controller.LOG.info(resultCommand);
                break;
             case REMOVE:
                resultCommand = new RemoveAir();
                break;
            case ADD_NEW_PERSON:
                resultCommand = new AddAirComp();
                break;

            default:{
                throw new IllegalArgumentException("Invalid command: " + commandEnum);
            }
        }
        return resultCommand;
    }
}