package sample;
import java.sql.*;
import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;


public class DataBaseHandler  extends Configs{
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    public static final Logger LOG = Logger.getLogger(DataBaseHandler.class);
    Connection dbConnection;
    public static Statement statement;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString="jdbc:mysql://"+ dbHost +":"
        +dbPort+"/"+dbName;
    /*    Class.forName("com.mysql.cj.jdbc.Driver");*/
        dbConnection = DriverManager.getConnection(connectionString,
               dbUser,dbPass );
        statement = dbConnection.createStatement();
        dbConnection.setAutoCommit(false);
        LOG.info("Connect");
        dbConnection.setAutoCommit(false);
        return dbConnection;
    }
    /*, String param, String data*/
    public void signUpUser(String name, String group, String discription, String data, String param){
        String insert="INSERT INTO " + Const.Product_Table + "(" +Const.Product_Name + "," +
                Const.Product_Group+","+Const.Product_Discrioption +","+
                Const.Product_Data+","+Const.Product_Param+")"

//                +name+","+ group +","+ discription;
                +" VALUES(?,?,?,?,?)";
        System.out.println(insert);
        try {
            PreparedStatement stp = getDbConnection().prepareStatement(insert);
            stp.setString(1, name);
            stp.setString(2, group);
            stp.setString(3, discription);
            stp.setString(4, data);
            stp.setString(5, param);
            stp.executeUpdate();
        }
        catch(SQLException e){

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void signUpUser(String name, String group, String discription, String parm){
        String insert="INSERT INTO " + Const.Product_Table + "(" +Const.Product_Name + "," +
                Const.Product_Group+","+Const.Product_Discrioption +
                ","+Const.Product_Param+
                ")"

//                +name+","+ group +","+ discription;
                +" VALUES(?,?,?,?)";
        System.out.println(insert);
        LOG.info(insert);
        try {
            PreparedStatement stp = getDbConnection().prepareStatement(insert);
            stp.setString(1, name);
            stp.setString(2, group);
            stp.setString(3, discription);
            stp.setString(4, parm);
            stp.executeUpdate();
        }
        catch(SQLException e){

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void signUpParam(String name, String unit){
        String insert="INSERT INTO " + Const.Param_Table + "(" +Const.Product_Name + "," +
                Const.Param_Unit+ ")"

//                +name+","+ group +","+ discription;
                +" VALUES(?,?)";
        System.out.println(insert);
        LOG.info(insert);
        try {
            PreparedStatement stp = getDbConnection().prepareStatement(insert);
            stp.setString(1, name);
            stp.setString(2, unit);

            stp.executeUpdate();
        }
        catch(SQLException e){

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
     public void Param_for_product() throws SQLException {
        String sqlCommand = "SELECT * FROM group_param WHERE name='Процессор' ";
        ResultSet resultset = statement.executeQuery(sqlCommand);
        System.out.printf("--------------Вывести перечень параметров для заданной группы продукции----------");

        while (resultset.next()) {
            String Group = resultset.getString(1);
            String Parms = resultset.getString(2);

            System.out.print("\nгруппа продукции: " + Group+" ,ее параметры: "+ Parms + "\n");
            LOG.info("\nгруппа продукции: " + Group+" ,ее параметры: "+ Parms + "\n");
            dbConnection.commit();
        }

    }
    public void Product() throws SQLException {
        String sqlCommand = "SELECT\n" +
                "  *\n" +
                "FROM\n" +
                "  product\n" +
                "WHERE\n" +
                "  param NOT LIKE '%камера%'";
        ResultSet resultset = statement.executeQuery(sqlCommand);
        System.out.printf("--------------Вывести перечень продукции, не содержащий заданного параметра----------");

        while (resultset.next()) {
            String Group = resultset.getString(1);
            System.out.print("\nгруппа продукции: " + Group);
            LOG.info("\nгруппа продукции: " + Group);
        }
        dbConnection.commit();
    }
    public void Group_Inf() throws SQLException {
        String sqlCommand =  "SELECT * FROM product WHERE group1='телевизор' ";
        ResultSet resultset = statement.executeQuery(sqlCommand);
        System.out.printf("\n--------------Вывести информацию о продукции для заданной группы----------");

        while (resultset.next()) {
            String Name = resultset.getString(1);
            String group = resultset.getString(2);
            String discr = resultset.getString(3);
            String parm = resultset.getString(4);
            System.out.print("\nназвание продукции: " + Name+" группа: "+group+" описание: "+discr+" параметры: "+parm);
            LOG.info("\nназвание продукции: " + Name+" группа: "+group+" описание: "+discr+" параметры: "+parm);
        }
        dbConnection.commit();
    }
    public void All_Inf() throws SQLException {
        String sqlCommand =  "SELECT * FROM product ";
        ResultSet resultset = statement.executeQuery(sqlCommand);
        System.out.printf("\n--------------Вывести информацию о продукции и всех ее параметраx---------");

        while (resultset.next()) {
            String Name = resultset.getString(1);
            String group = resultset.getString(2);
            String discr = resultset.getString(3);
            String parm = resultset.getString(4);
            System.out.print("\nназвание продукции: " + Name+" группа: "+group+" описание: "+discr+" параметры: "+parm);
            LOG.info("\nназвание продукции: " + Name+" группа: "+group+" описание: "+discr+" параметры: "+parm);
        }
        dbConnection.commit();
    }
}
