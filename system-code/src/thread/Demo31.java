package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo31 {

    // 简单的生产者消费者模型的代码案例
    // 使用一个线程表示生产者
    // 使用一个线程表示消费者
    // 搞一个阻塞队列 生产者往阻塞队列中放一个整数 消费者进行获取
    public static void main(String[] args) {

        BlockingQueue<Long> queue = new ArrayBlockingQueue<>(1000);
        // 生产
        Thread thread1 = new Thread(() -> {
            long n = 0;
            while (true) {
                try {
                    queue.put(n);
                    System.out.println("生产了: " + n);
                    n++;
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // 消费者
        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    Long n = queue.take();
                    System.out.println("消费了: " + n);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}
