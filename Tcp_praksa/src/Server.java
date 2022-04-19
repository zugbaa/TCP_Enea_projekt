import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ServerSocket serverSocket;
    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }
    public void startServer() throws IOException {

            while (true) {
                Socket socketClient = serverSocket.accept();
                System.out.println("a client has connected");
                ClientHandler clientThread = new ClientHandler(socketClient);

                Thread thread = new Thread(clientThread);
                thread.start();

            }
    }

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        server.startServer();

    }
}
