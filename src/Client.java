import java.io.*;
import java.net.Socket;

public class Client {

    String hostName;

    int port;

    Socket clientSocket;



    public Client(String hostName, int port){
        this.hostName = hostName;
        this.port = port;
    }

    public String SendMessageToServer(String message) throws IOException {

        clientSocket = new Socket(hostName, port);

        OutputStream outputStream = clientSocket.getOutputStream();

        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        InputStream inputStream = clientSocket.getInputStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader reader = new BufferedReader(inputStreamReader);

        writer.write(message +"\n");

        writer.flush();

        String response = reader.readLine();

        writer.close();

        reader.close();

        clientSocket.close();

        return response;
    }
}
