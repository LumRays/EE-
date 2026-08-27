package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Demo30 {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(100);
        BlockingQueue<String> blockingQueue2 = new LinkedBlockingQueue<>();
        BlockingQueue<String> blockingQueue3 = new PriorityBlockingQueue<>();

        // 入队列
        blockingQueue.put("hello");
        // 出队列
        String elm = blockingQueue.take();

    }

}
