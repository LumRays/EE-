package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo37 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建线程 让其计算 1 + 2 + ... + 1000
        // 由主线程输出结果

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        // 对于 Thread 来说 无法直接接收 Callable 对象作为参数
        // 此处需要搭配 FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);

        thread.start();
        // get 方法拿到 call 方法的返回结果 若 call 方法还没有执行完 get 就会阻塞等待
        System.out.println(futureTask.get());

    }

}
