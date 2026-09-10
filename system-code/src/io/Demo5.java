package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo5 {

    public static void main(String[] args) {

        try(OutputStream outputStream = new FileOutputStream("d:/test.txt", true)) {

//            outputStream.write(65);
//            outputStream.write(66);
//            outputStream.write(67);
//            outputStream.write(68);
//            outputStream.write(69);
//            outputStream.write(70);

            byte[] bytes = {65, 66, 67, 68, 69, 70};
            outputStream.write(bytes);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
