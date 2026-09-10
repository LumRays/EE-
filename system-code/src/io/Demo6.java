package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo6 {

    public static void main(String[] args) {

        try(Reader reader = new FileReader("d:/test.txt")) {

//            while (true) {
//                int n = reader.read();
//                if (n == -1) {
//                    break;
//                }
//                char ch = (char) n;
//                System.out.println(ch);
//            }

            while (true) {
                char[] chars = new char[1024];
                int n = reader.read(chars);
                if (n == -1) {
                    break;
                };
                for (int i = 0; i < n; i++) {
                    System.out.println(chars[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
