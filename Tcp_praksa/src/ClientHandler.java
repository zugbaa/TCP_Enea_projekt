import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket client;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
    }

    @Override
    public void run() {
        try {
            while (true){
                String msg = this.bufferedReader.readLine();
                System.out.println("Client:" + msg);

                if (msg.equalsIgnoreCase("ping")){
                    this.bufferedWriter.write("Pong");
                }else {
                    this.bufferedWriter.write("Msg received");
                }

                this.bufferedWriter.newLine();
                this.bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
