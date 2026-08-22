package thread;

import java.util.Scanner;

public class Demo24 {

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
            synchronized (locker) {
                System.out.println("thread2 wait 之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread2 wait 之后");
            }
        });

        Thread thread3 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("thread3 wait 之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread3 wait 之后");
            }
        });

        thread2.start();
        thread3.start();
        thread1.start();

        Thread thread4 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("thread5 notify 之前");
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入任意内容,触发 notify: ");
                scanner.next();
                //locker.notify();
                locker.notifyAll();
                System.out.println("thread5 notify 之后");
            }
        });

        thread4.start();

    }

}
