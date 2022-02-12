public class Main {
    static final int countTreads = 64;
    static final int port = 9999;

    public static void main(String[] args) {
        Server server = new Server(countTreads);
        server.startServer(port);

    }
}


