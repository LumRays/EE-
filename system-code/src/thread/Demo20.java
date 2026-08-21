package thread;

import java.util.Scanner;

public class Demo20 {

    private static volatile int flag = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (flag == 0) {
                // 循环体啥都不做

            }
            System.out.println("thread1 结束");
        });

        Thread thread2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入 flag 的值: ");
            flag = scanner.nextInt();
            System.out.println("thread2 结束");
        });

        thread1.start();
        thread2.start();

    }

}
