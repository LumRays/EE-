package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {

    // 创建 socket 对象
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        System.out.println("client start!");
        Scanner scanner = new Scanner(System.in);
        // 用户通过控制台输入字符串 将其发给服务器 让服务器读取响应
        while (true) {
            System.out.print("-> ");
            String request = scanner.next();
            if (request.equals("exit")) {
                break;
            }
            // 将用户输入的字符串构造成 UDP 数据报 进行发送
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length, InetAddress.getByName(this.serverIp), this.serverPort);
            socket.send(requestPacket);
            // 从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            // 显示响应内容
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {

        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9998);
        client.start();
    }

}
