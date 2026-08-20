package thread;

import java.util.Random;

public class Demo18 {

    private static long sum1 = 0;
    private static long sum2 = 0;

    public static void main(String[] args) throws InterruptedException {

        int[] arr = new int[1000_0000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }

        long start = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arr.length; i+=2) {
                sum1 += arr[i];
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i < arr.length; i+=2) {
                sum2 += arr[i];
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long result = sum1 + sum2;

        long time = System.currentTimeMillis() - start;

        System.out.println(result);
        System.out.println("运行耗时(ms): " + time);

    }

}
