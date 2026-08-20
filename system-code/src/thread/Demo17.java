package thread;

public class Demo17 {

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (locker1) {
                System.out.println("thread1 获取到 locker1");
                sleep(1000);
                synchronized (locker2) {
                    System.out.println("thread1 获取到 locker2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (locker2) {
                System.out.println("thread2 获取到 locker2");
                sleep(1000);
                synchronized (locker1) {
                    System.out.println("thread2 获取到 locker1");
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}
