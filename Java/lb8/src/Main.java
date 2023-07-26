import Connect.Connection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
public class Main {
    public static void main(String[] args) throws IOException {

        //1
        Connection connect = new Connection();
        connect.GetByName("www.ivi.ru");
        connect.ReadCont("https://www.ivi.ru");
     //   connect.ConnectInfo("https://www.ivi.ru");
        //2

    }
}