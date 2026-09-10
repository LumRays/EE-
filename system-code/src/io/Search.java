package io;

import java.io.File;
import java.util.Scanner;

public class Search {

    public static void main(String[] args) {

        // 1. 让用户输入一个要扫描的路径
        System.out.println("请输入要扫描的路径: ");
        Scanner scanner = new Scanner(System.in);
        String rootPath = scanner.next();
        // 2. 让用户输入一个要搜索的文件名关键字
        System.out.println("请输入要搜索的文件名关键字: ");
        String word = scanner.next();
        // 3. 验证用户输入是否合法
        if (word.isEmpty()) {
            System.out.println("输入的关键字为空! ");
            return;
        }
        File rootFile = new File(rootPath);
        if (!rootFile.isDirectory()) {
            // 路径不存在或者路径对应的是普通文件
            System.out.println("路径输入有误! ");
            return;
        }
        // 4. 进行搜索
        search(rootFile,word);

    }

    public static void search(File rootFile, String word) {
        File[] files = rootFile.listFiles();
        if (files == null) {
            return;
        }
        for(File file : files) {
            // 判断当前 file 是否是文件
            if (file.isFile()) {
                // 判断当前文件名是否包含 word
                tryDelete(file, word);
            }else if (file.isDirectory()) {
                // 对子目录进行递归
                search(file,word);
            }else {
                // 正常情况下不能走到这里  暂时啥都不做

            }
        }
    }

    private static void tryDelete(File file, String word) {
        Scanner scanner = new Scanner(System.in);
        boolean exists = file.getName().contains(word);
        if (exists) {
            System.out.println("找到文件: " + file.getAbsolutePath());
            System.out.println("是否进行删除? (y/n)");
            String choice = scanner.next();
            if (choice.equals("y") || choice.equals("Y")) {
                file.delete();
            } else {
                System.out.println("取消删除");
            }
        }
    }

}
