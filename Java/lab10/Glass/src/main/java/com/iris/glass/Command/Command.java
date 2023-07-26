package com.iris.glass.Command;


/*import com.example.lab_13.Exceptions.StandartException;*/
import com.iris.glass.Exepcions.StandartException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.SQLException;

public interface Command {
    CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, StandartException;

    CommandResult execute(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws SQLException;
}