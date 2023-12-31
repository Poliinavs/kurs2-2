import java.io.*;
import java.net.Socket;

public class ServerThread {
    static class serverThread extends Thread {

        private Socket socket;
        private BufferedReader reader;
        private BufferedWriter writer;

        public serverThread(Socket socket) throws IOException {
            this.socket = socket;
            //Класс BufferedReader считывает текст из символьного потока ввода, буферизируя прочитанные символы.
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //Java класс BufferedWriter записывает текст в поток вывода символов, буферизуя записанные символы, чтобы обеспечить эффективную запись символов, массивов и строк. Можно указать
            // в конструкторе вторым параметром размер буфера.
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
         //   Server.messageStory.printStory(writer);
            start();
        }
        @Override
        public void run() {
            try {
                var message = reader.readLine();
                try {
                    writer.write(message + "\n");
                    writer.flush();
                } catch (IOException ignored) {}
                try {
                    while (true) {
                        message = reader.readLine();

                        if(message.equals("end")) {
                            this.downService();
                            break;
                        }
                        System.out.println(message);
//                        Server.messageStory.addStoryElement(message);
                        for (serverThread vr : server.serverThreads) {
                            vr.send(message);
                        }
                    }
                } catch (NullPointerException ignored) {}
            } catch (IOException e) {
                this.downService();
            }
        }
        private void send(String message) {
            try {
                writer.write(message + "\n");
                writer.flush();
            } catch (IOException ignored) {}
        }
        private void downService() {
            try {
                if(!socket.isClosed()) {
                    socket.close();
                    reader.close();
                    writer.close();
//                    for (ServerThread  vr : Server.serverThreads) {
//                        if(vr.equals(this)) vr.interrupt();
//                        Server.serverThreads.remove(this);
//                    }
                }
            } catch (IOException ignored) {}
        }
    }

}
