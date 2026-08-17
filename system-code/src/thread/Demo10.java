package thread;

public class Demo10 {

    private static int sum = 0;

    public static void main(String[] args) throws InterruptedException {

        // 创建一个线程 让这个线程计算 1 + 2 + 3 + ... + 1000
        // 主线程在这个计算线程执行完毕后 打印此处的结果
        Thread thread = new Thread(() -> {
            for (int i = 0; i <= 1000; i++) {
                sum += i;
            }
            System.out.println("thread 线程计算完毕");
        });
        thread.start();
        // join 等待 thread 线程结束
        thread.join();
        System.out.println("thread 线程计算结果为 " + sum);
    }

}
