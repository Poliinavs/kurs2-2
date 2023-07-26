package ex2;
import java.io.*;
import java.net.Socket;

    class serverThread extends Thread {

        private Socket socket;


        private BufferedReader reader;
        private BufferedWriter writer;

        public serverThread(Socket socket) throws IOException {
            this.socket = socket;
            server.sc.add(socket);
                                                                                                 //Класс BufferedReader считывает текст из символьного потока ввода, буферизируя прочитанные символы.
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                                                              //Java класс BufferedWriter записывает текст в поток вывода символов, буферизуя записанные символы, чтобы обеспечить эффективную запись символов, массивов и строк. Можно указать
                                                                               // в конструкторе вторым параметром размер буфера.
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            server.messageStory.printStory(writer);
            start();
        }

        @Override
        public void run() {
            try {
                writer.write( "Вы присоединились к игре, отгадайте число\n");
                writer.flush();
                var message = reader.readLine();
                String str;
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
//                        System.out.println(message.substring(message.lastIndexOf(" ")));
                        String st= message.substring(message.lastIndexOf(" "));
                        st=st.substring(1);
                        if(st.equals(server.number)) {

                            System.out.println("Вы выйграли");
                            for (serverThread vr : server.serverThreads) {
                                vr.send("Игра пройдена");
                            }
                            server.generate();

                        }

                        System.out.println(message);
                        server.messageStory.addStoryElement(message);

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

        public void downService() {
            try {
                if(!socket.isClosed()) {
                    reader.close();
                    writer.close();
                    socket.close();

//                    for (serverThread vr : server.serverThreads) {
//                        if(vr.equals(this)) vr.interrupt();
//                        server.serverThreads.remove(this);
//                    }
                }
            } catch (IOException ignored) {}
        }
    }


