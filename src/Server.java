import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        // создаем серверный сокет на порту 1234
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Ожидаем клиентов...");

        // ждем клиента
        Socket s = server.accept();
        System.out.println("Клиент подключился!");

        // получаем потоки ввода и вывода
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();

        // создаем удобные средства ввода и вывода
        Scanner in = new Scanner(is);
        PrintStream out = new PrintStream(os);

        // читаем из сети и пишем в сеть
        out.println("Имя?");
        out.println("Привет, " + in.nextLine() + "! Мы тебя ждали!!!");
    }
}