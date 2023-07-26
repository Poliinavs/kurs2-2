package ex2;

import java.io.*;
import java.net.Socket;

public class client   {
    private static final String IPAddress = "localhost";
    private static final int PORT = 4007;

    public static void main(String[] args) {

        new ClientThread(IPAddress, PORT);

    }
    }

 class ClientThread {

    public Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private BufferedReader inputUser;
    private final String address;
    private final int port;
    public static String name;
     public static String companion;
    public ClientThread(String address, int port) {
        this.address = address;
        this.port = port;

        try {
            //Соединение с сокетом сервера
            this.socket = new Socket(address, port);

        } catch (IOException e) {
            System.err.println("Socket failed");
        }

        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                                                                                       //Получение ссылки на поток сервера
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.pressName();
            new ReadMessage().start();
            new WriteMessage().start();
        } catch (IOException e) {
            ClientThread.this.downService();
        }
    }

    private void pressName() {
        System.out.print("Enter your name: ");
        try {
            name = inputUser.readLine();
            writer.write("New user in chat " + name );
            writer.flush();


        } catch (IOException ignored) { }
    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                reader.close();
                writer.close();
             }
        } catch (IOException ignored) {}
    }

    private class ReadMessage extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    var message = reader.readLine();
                    System.out.println(message);
                }
            } catch (IOException e) {
                ClientThread.this.downService();
            }
        }
    }

    public class WriteMessage extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    var message = inputUser.readLine();
                    if (message.equals("end")) {
                        writer.write("end" + "\n");
                        ClientThread.this.downService();
                        break;
                    } else {
                        writer.write( name + ": " + message + "\n");
                    }

                    if(message.equals(server.number)) {

                        System.out.println("Вы выйграли");
                        ClientThread.this.downService();
                        break;
                    }
                    writer.flush();

                } catch (IOException e) {
                    ClientThread.this.downService();
                }
            }
        }
    }
}