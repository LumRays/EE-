package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo7 {

    public static void main(String[] args) {

        try(Writer writer = new FileWriter("d:/test.txt")) {

            writer.write("Hello World");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
