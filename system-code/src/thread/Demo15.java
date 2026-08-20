package thread;

class Counter {
    public int count = 0;

    // 把 synchronized 加到实例方法上 此时就是给 this 加锁
    synchronized public void add() {

        count++;

    }

}

public class Demo15 {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.count);

    }

}
