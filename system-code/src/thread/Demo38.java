package thread;

import java.util.concurrent.Semaphore;

public class Demo38 {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(4);

        // P 操作
        semaphore.acquire();
        System.out.println("进行 P 操作");
        semaphore.acquire();
        System.out.println("进行 P 操作");
        semaphore.acquire();
        System.out.println("进行 P 操作");
        semaphore.acquire();
        System.out.println("进行 P 操作");


        // V 操作
        semaphore.release();
        System.out.println("进行 V 操作");

        semaphore.acquire();
        System.out.println("进行 P 操作");

    }

}
