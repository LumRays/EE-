package thread;

import java.util.concurrent.CountDownLatch;

public class Demo40 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(8);

        for (int i = 0; i < 8; i++) {
            int tmp = i;
            Thread thread = new Thread(() -> {
                System.out.println("运动员 " + tmp + " 开始");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("运动员 " + tmp + " 到达终点");
                // latch 中保存的计数值就 - 1
                latch.countDown();
            });
            thread.start();
        }

        // 主线程如何判定所有运动员到达终点?
        // await => all wait 等待所有
        latch.await();
        System.out.println("比赛结束");

    }

}
