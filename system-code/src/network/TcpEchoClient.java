package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {

    private Socket socket = null;

    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        socket = new Socket(serverIp,serverPort);
    }

    public void start() {
        System.out.println("client start!");
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            Scanner scanner = new Scanner(System.in);
            Scanner scannerNetwork = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);

            while (true) {
                // 1. 从控制台读取用户输入
                System.out.println("-> ");
                String request = scanner.next();
                // 2. 把请求发送给服务器
                writer.println(request);
                writer.flush();
                // 3. 从服务器读取响应
                if (!scannerNetwork.hasNext()) {
                    break;
                }
                String response = scannerNetwork.next();
                // 4. 把响应显示到控制台上
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9999);
        client.start();
    }

}
