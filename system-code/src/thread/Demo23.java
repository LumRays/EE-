package thread;

import java.util.Scanner;

public class Demo23 {

    public static void main(String[] args) {

        Object locker = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("thread1 wait 之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread1 wait 之后");
            }
        });

        Thread thread2 = new Thread(() -> {
            // notify 和 wait 类似, 也是放到 synchronized 内部的
            synchronized (locker) {
                System.out.println("thread2 notify 之前");
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入任意内容,触发 notify: ");
                scanner.next();
                locker.notify();
                System.out.println("thread2 notify 之后");
            }
        });

        thread1.start();
        thread2.start();

    }

}
