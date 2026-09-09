package io;

import java.io.File;

public class Demo2 {

    public static void main(String[] args) {

        File file = new File("d:/");
//        String[] fileNames = file.list();
//        if (fileNames == null) {
//            System.out.println("空目录");
//            return;
//        }
//        for (String fileName : fileNames) {
//            System.out.println(fileName);
//        }

        File[] files = file.listFiles();
        if (files == null) {
            System.out.println("空目录");
            return;
        }
        for(File f : files) {
            System.out.println(f.getName());
        }

    }

}
