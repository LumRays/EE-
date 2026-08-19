package thread;

public class Demo12 {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        // 创建两个线程 分别对同一个变量进行 5w 次的 ++ 操作
        // 最终主线程打印结果

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        thread1.start();
        thread2.start();

        // 让主线程等待上述的两个线程执行完毕
        thread1.join();
        thread2.join();

        // 预估值为 10w 才对,结果呢?
        System.out.println("执行 5w 次的 count++ 操作后, count = " + count);

    }

}
