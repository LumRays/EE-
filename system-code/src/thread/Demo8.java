package thread;

import java.util.Scanner;

public class Demo8 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            Thread cur = Thread.currentThread();
            while (!cur.isInterrupted()) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000_0000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数(0 表示让线程 thread 结束)");
        int n = scanner.nextInt();
        if (n == 0) {
            // 这个方法不仅可以设置标志位 还能唤醒 sleep 等导致线程阻塞的方法
            // 会使 sleep 抛出异常 InterruptedException
            thread.interrupt();
        }
    }

}
