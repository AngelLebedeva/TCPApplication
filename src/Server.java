import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

    int port;
    ServerSocket serverSocket;

    InetAddress address;


    public Server(String address, int port) throws UnknownHostException {

        this.port = port;

        this.address = InetAddress.getByName(address);
    }

    public void Run() throws IOException {
        serverSocket = new ServerSocket(port, 0, address);

        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

        Date date = new Date();
        String formattedDate = formatForDateNow.format(date);

        System.out.println("Server run at " + formattedDate);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String request = reader.readLine();

            date = new Date();
            formattedDate = formatForDateNow.format(date);

            System.out.println("Message from Client \"" + request + "\" successfully received by server at " + formattedDate);

            String response = "Message \"" + request + "\" successfully received by server at " + formattedDate;

            writer.write(response);

            writer.flush();

            reader.close();

            writer.close();

            clientSocket.close();
        }

    }

}
