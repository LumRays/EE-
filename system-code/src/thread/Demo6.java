package thread;

public class Demo6 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("thread 线程结束");
        });

        // 在 start 之前, 把 thread 设定为后台线程
        thread.setDaemon(true);

        thread.start();

        Thread.sleep(1000);
        System.out.println("main 线程结束");

        // 退出程序 指定退出码
        // System.exit(1);

    }

}
