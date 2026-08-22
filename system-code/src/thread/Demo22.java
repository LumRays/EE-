package thread;

public class Demo22 {

    public static void main(String[] args) throws InterruptedException {

        // 使用 wait
        Object object = new Object();
        synchronized (object) {
            System.out.println("wait 之前");
            object.wait();
            System.out.println("wait 之后");
        }

    }

}
