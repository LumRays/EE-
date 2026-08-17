package thread;

public class Demo11 {

    private static int sum = 0;

    public static void main(String[] args) {

        // 先获取到指向 main 线程的引用
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            // 主线程中计算结果
            // 而 thread 线程中打印结果
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("主线程计算结果为 " + sum);
        });
        thread.start();
        for (int i = 0; i <= 1000; i++) {
            sum += i;
        }
        System.out.println("主线程计算完毕");

    }

}
