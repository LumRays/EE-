package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo33 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            // 此处的 temp 是 "事实 final"
            final int temp = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String name = Thread.currentThread().getName();
                    System.out.println("hello " + name + ", " + temp);
                }
            });
        }
        //Executors.newFixedThreadPool(4);

    }

}
