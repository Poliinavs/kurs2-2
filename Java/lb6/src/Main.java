import org.apache.log4j.xml.DOMConfigurator;
import sample.DataBaseHandler;

import java.sql.SQLException;
import org.apache.log4j.*;
public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    public static final Logger LOG = Logger.getLogger(Main.class);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        DataBaseHandler dbHandler = new DataBaseHandler();
//       dbHandler.signUpUser("Apple", "fruuuuit", "red apple","1" );
//       dbHandler.signUpUser("Samsung", "telephone", "Смартфон с OLED-экраном","2008", "1");
        //param ////////////////
//        dbHandler.signUpParam("size","mm" );
//        dbHandler.signUpParam("permission","px" );
     // dbHandler.signUpParam("Камера","mp" );
//
        dbHandler.getDbConnection();
//        LOG.info("Start query 2");
        dbHandler.Param_for_product();
//        LOG.info("Start query 3");
        dbHandler.Product();
//        LOG.info("Start query 4");
        dbHandler.Group_Inf();
//        LOG.info("Start query 5");
        dbHandler.All_Inf();
        try{

        }
        catch (Exception ex){

        }

      //  dbHandler.Param_for_product();
    }
}