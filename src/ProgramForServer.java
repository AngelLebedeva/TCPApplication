import java.io.IOException;

public class ProgramForServer {

    public static void main(String[] args) throws IOException {

        Server server = new Server("127.0.0.1", 22222);

        server.Run();
    }

}
