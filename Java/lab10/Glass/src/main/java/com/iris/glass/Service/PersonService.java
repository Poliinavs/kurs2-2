package com.iris.glass.Service;
import com.iris.glass.Controller.Controller;
import com.iris.glass.DataBase.Repository.RepositoryUser;

import com.iris.glass.Exepcions.StandartException;
import com.iris.glass.Model.User;

public class PersonService {
    public static boolean addPerson(User user)
    {
        try
        {
            RepositoryUser.AddUserToDb(user.login, user.password);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    public static boolean LogIn(User user) throws StandartException {
        try {

            if(RepositoryUser.LogInUser(user.login, user.password))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception ex)
        {
            throw new StandartException("Ошибка при обращении к БД", ex);
        }
    }

}
