package Connect;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.net.*;

public class Connection {
    public void  GetByName(String name){
        try {
            var Ip = InetAddress.getByName(name);
            System.out.println("IP -> " + Ip.getHostAddress());
        }
        catch (UnknownHostException e) { // если не удается найти IP
            System.err.println(e.getMessage());
        }
    }
    public void ReadCont(String urlName) throws IOException
    {   URL tut = null;
        FileWriter fileIn = new  FileWriter("src/file/inform.txt");
        try {
            tut = new URL(urlName);
        } catch (MalformedURLException e) {
// некорректно заданы протокол, доменное имя или путь к файлу
            e.printStackTrace();
        }
        if (tut == null) {
            throw new RuntimeException();
        }
        try (BufferedReader d = new BufferedReader(new InputStreamReader(tut.openStream())))
        {
            String line = "";
            while ((line = d.readLine()) != null) {
                fileIn.write(line);
               // System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); }
    }
    public void ConnectInfo(String urlName)
    {   int timeout = 10_000;
        try {
            URL url = new URL(urlName);
            final URLConnection connection1 = url.openConnection();
// установка таймаута на соединение
            connection1.setConnectTimeout(timeout);
            System.out.println(urlName + " content type: "+
                    "\n" + connection1.getContentType()+
                    "\n" +connection1.getClass()+
                    "\n" + connection1.getContentLength());
// продолжение извлечения информации из соединения
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }}

}
