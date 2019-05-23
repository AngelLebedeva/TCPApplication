import java.io.IOException;
import java.util.Scanner;

public class ProgramForClient {

    public static void main(String[] args) throws IOException {

        Client client = new Client("127.0.0.1", 22222);

        Scanner scanner = new Scanner(System.in);

        String myMessage;

        while (true) {

            System.out.println("Введите сообщение для отправки на сервер");

            myMessage = scanner.nextLine();

            String responceFromServer = client.SendMessageToServer(myMessage);

            System.out.println("Сообщение от сервера: " + responceFromServer);



        }
    }


}
