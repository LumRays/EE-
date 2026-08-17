package thread;

import java.util.Scanner;

public class Demo7 {

    private static boolean running = true;

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            while (running) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("thread 线程退出");
        });
        thread.start();

        // 主线程中 让用户进行输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入整数(0 表示让 thread 线程终止)");
        int n = scanner.nextInt();
        if (n == 0) {
            running = false;
        }

    }

}
