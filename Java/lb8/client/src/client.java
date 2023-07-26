public class client   {
    private static final String IPAddress = "localhost";
    private static final int PORT = 4006;
    public static void main(String[] args) {

        new ClientThread(IPAddress, PORT);
    }
}