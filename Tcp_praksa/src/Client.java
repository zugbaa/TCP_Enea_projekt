import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }
    public void sendMessage() throws IOException {

            Scanner scanner = new Scanner(System.in);

            while (true){
                String msg = scanner.nextLine();

                bufferedWriter.write(msg);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                System.out.println("Server:" + bufferedReader.readLine());
            }
    }

    public static void main(String[] args) throws IOException {
            Socket socket = new Socket("localhost", 1234);
            Client client = new Client(socket);
            client.sendMessage();
    }
}
