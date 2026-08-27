package thread;

// 此处暂时不考虑泛型
// 只保存 String 类型
class MyBlockingQueue {
    // 通过数组表示当前阻塞队列
    private String[] data;
    // [head,tail) 队列中有效元素的区间
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    // 手动定义锁对象 使用 this 也行
    private Object locker = new Object();

    public MyBlockingQueue(int capacity) {
        data = new String[capacity];
    }

    public void put(String elem) throws InterruptedException {
        synchronized (locker) {
            while (size == data.length) {
                // 队列已满 阻塞
                locker.wait();
                //return;
            }
            data[tail++] = elem;
            if (tail >= data.length) {
                tail = 0;
            }
            size++;
            locker.notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized (locker) {
            while (size == 0) {
                locker.wait();
                //return null;
            }
            // 取出 head 位置的元素
            String ret = data[head++];
            if (head >= data.length) {
                head = 0;
            }
            size--;
            locker.notify();
            return ret;
        }
    }

}

public class Demo32 {

    public static void main(String[] args) {

        MyBlockingQueue queue = new MyBlockingQueue(1000);
        Thread thread1 = new Thread(() -> {
            long n = 0;
            while (true) {
                try {
                    queue.put(n + "");
                    System.out.println("生产了: " + n);
                    n++;
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    String n = queue.take();
                    System.out.println("消费了: " + n);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}
