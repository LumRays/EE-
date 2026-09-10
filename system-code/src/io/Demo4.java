package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo4 {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = new FileInputStream("d:/test.txt");
        // 创建流对象的过程 相当于"打开文件"
//        while (true) {
//            int n = inputStream.read();
//            if (n == -1) {
//                // 读取到文件末尾了 读取完毕
//                break;
//            }
//            System.out.printf("%x\n", n);
//        }

        while (true) {
            byte[] bytes = new byte[1024];
            int n = inputStream.read(bytes);
            if (n == -1) {
                break;
            }
            for (int i = 0; i < n; i++) {
                System.out.printf("%x\n", bytes[i]);
            }
        }

        inputStream.close();

//        =================================================

        // 使用 try with resources 语法解决上述问题
        // try 代码块执行完毕后 自动调用 close
        try(InputStream inputStream2 = new FileInputStream("d:/test.txt")) {
            while (true) {
                byte[] bytes = new byte[1024];
                int n = inputStream.read(bytes);
                if (n == -1) {
                    break;
                }
                for (int i = 0; i < n; i++) {
                    System.out.printf("%x\n", bytes[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
