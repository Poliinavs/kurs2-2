package ex2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class server {

    public static final int PORT = 4007;
    public static LinkedList<serverThread> serverThreads = new LinkedList<>();
    public static LinkedList<Socket> sc = new LinkedList<>();
    public static LinkedList<String> names= new LinkedList<>();

    public static MessageStory messageStory;
public static String number;
    public static synchronized  void addname(String name){
        names.add(name);
    }

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(PORT);
        messageStory = new MessageStory();
         generate();

        System.out.println("Server is listening on port " + PORT);

        try {
            while (true) {
                Socket socket = server.accept();                                                        //ожидает клиента и возвращает его сокет
                try {
                    serverThreads.add(new serverThread(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
    public static void  generate(){
        int number1 = (int) ( Math.random() * 10 );
        number = Integer.toString(number1);
        System.out.println("\nNumber " + number);
    }
}

//import java.io.*;
//import java.net.*;
//
//public class server {
//    public static void main(String[] args) {
//        try {
//            ServerSocket serverSocket = new ServerSocket(1234);
//            while (true) {
//                Socket socket = serverSocket.accept();
//                new Thread(new ClientHandler(socket)).start();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//class ClientHandler implements Runnable {
//    private Socket socket;
//    private BufferedReader in;
//    private PrintWriter out;
//
//    public ClientHandler(Socket socket) {
//        this.socket = socket;
//    }
//
//    public void run() {
//        try {
//            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            out = new PrintWriter(socket.getOutputStream(), true);
//
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                // Обработка данных от клиента
//                String outputLine = "Processed data: " + inputLine;
//                out.println(outputLine);
//            }
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}