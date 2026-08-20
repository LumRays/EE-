package thread;

public class Demo16 {

    private static int count = 0;

    synchronized private static void add() {

        count++;

    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                add();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                add();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);

    }

}
