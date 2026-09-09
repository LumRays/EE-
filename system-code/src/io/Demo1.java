package io;

import java.io.File;
import java.io.IOException;

public class Demo1 {

    public static void main(String[] args) throws IOException {

//        File file = new File("./test.txt");
//        System.out.println(file.getParent());
//        System.out.println(file.getName());
//        System.out.println(file.getPath());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getCanonicalPath());
//        System.out.println(file.exists());
//        file.createNewFile();
//        System.out.println(file.exists());
//        file.delete();
//        System.out.println(file.exists());
//        file.deleteOnExit();

        File source = new File("d:/test.txt");
        File destination = new File("d:/test2.txt");
        source.renameTo(destination);

    }

}
