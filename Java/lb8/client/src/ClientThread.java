import java.io.*;
import java.net.Socket;
public class ClientThread {
    private final String address;
    private final int port;
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private BufferedReader inputUser;
    private String nickname;
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
           // inputUser = new BufferedReader(new InputStreamReader(System.in));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //Получение ссылки на поток сервера
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
           // this.pressName();
            new ReadMessage().start();
            new WriteMessage().start();
        } catch (IOException e) {
            ClientThread.this.downService();
        }
    }
    private void pressName() {
        System.out.print("Enter your name: ");
        try {
            nickname = inputUser.readLine();
            writer.write("Welcome to the chat " + nickname + "!\n");
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

            for (int i=0; i<10; i++) {
                try {
                   // var message = inputUser.readLine();
                    var message="sd";
                    if (message.equals("end")) {
                        writer.write("end" + "\n");
                        ClientThread.this.downService();
//                        break;
                    } else {

                        writer.write(  ": " + message + "\n");
                    }
                    writer.flush();
                } catch (IOException e) {
                    ClientThread.this.downService();
                }
            }
        }
    }

}
