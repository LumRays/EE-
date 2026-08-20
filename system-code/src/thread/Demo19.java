package thread;

public class Demo19 {

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[20];
        // 创建 20 个线程对象
        for (int i = 0; i < 20; i++) {
            int num = i;
            threads[i] = new Thread(() -> {
                System.out.println(num);
            });

        }

        for (int j = 0; j < 20; j++) {
            threads[j].start();
        }

        for (int k = 0; k < 20; k++) {
            threads[k].join();
        }

        System.out.println("ok");

    }

}
