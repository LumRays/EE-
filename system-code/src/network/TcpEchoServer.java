package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoServer {
    
    private ServerSocket serverSocket = null;
    
    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    
    public void start() throws IOException {
        System.out.println("server start!");
        while (true) {
            // 首先要接受客户端的连接 然后才可以进行通信
            // 若有客户端和服务器建立好了连接 accept能够返回 否则 accept 会阻塞
            Socket socket = serverSocket.accept();
            // 通过以下方法处理该客户端整个的连接过程
            processConnection(socket);
        }
    }

    private void processConnection(Socket socket) {
        System.out.printf("[%s:%d] 客户端上线!\n", socket.getInetAddress(), socket.getPort());
        try (InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream()) {

            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            while (true) {
                // 处理多次请求/响应的读写操作
                // 一次循环就是读写一个请求/响应
                // 1. 读取请求并解析
                if (!scanner.hasNext()) {
                    // 客户端关闭了连接
                    System.out.printf("[%s:%d] 客户端下线!\n", socket.getInetAddress(), socket.getPort());
                    break;
                }
                String request = scanner.next();
                // 2. 根据请求计算响应
                String response = process(request);
                // 3. 把响应写回给客户端
                writer.println(response);
                writer.flush();
                // 4. 打印日志
                System.out.printf("[%s:%d] request: %s, response: %s\n", socket.getInetAddress(), socket.getPort(), request, response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9999);
        server.start();
    }

}
