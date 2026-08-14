package thread;

// 创建一个类 让它继承标准库的 Thread类
class MyThread extends Thread {
    @Override
    public void run() {

        while (true) {
            System.out.println("hello thread");
            // 休息 1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

public class Demo1 {

    public static void main(String[] args) {

        Thread thread = new MyThread();
        // 启动线程
        thread.start();
        while (true) {
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
