package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {

    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    // 启动服务器
    public void start() throws IOException {
        System.out.println("server start!");
        while (true) {
            // 1. 读取请求并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket);
            // 此处把二进制数据转成字符串
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            // 2. 根据请求计算响应
            String response = process(request);
            // 3. 将响应返回客户端  再构造一个 DatagramPacket
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(responsePacket);
            // 4. 打印日志
            System.out.printf("[%s:%d] request: %s, response: %s\n", requestPacket.getAddress().toString(), requestPacket.getPort(), request, response);
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {

        UdpEchoServer server = new UdpEchoServer(9999);
        server.start();

    }

}
