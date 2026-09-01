package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo36 {

    // 使用原子类
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count.getAndIncrement();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count.getAndIncrement();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("count = " + count);

    }

}
