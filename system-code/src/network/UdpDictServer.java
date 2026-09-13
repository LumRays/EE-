package network;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDictServer extends UdpEchoServer {

    private Map<String, String> dict = new HashMap<String, String>();

    public UdpDictServer(int port) throws SocketException {
        super(port);
        dict.put("hello", "你好");
        dict.put("industrious", "勤奋的");
        dict.put("world", "世界");
        dict.put("splendid", "壮丽的");
        dict.put("successful", "成功的");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "没有查询到该单词");
    }

    public static void main(String[] args) throws IOException {

        UdpDictServer server = new UdpDictServer(9998);
        server.start();

    }

}
