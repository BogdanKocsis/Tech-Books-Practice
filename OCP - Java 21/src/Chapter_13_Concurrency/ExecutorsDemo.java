package Chapter_13_Concurrency;

import java.util.concurrent.*;

public class ExecutorsDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(() -> 1 + 1);

        executorService.submit(() -> System.out.println("Runnable"));

        // future.get(); waits until thread is complete
        System.out.println(future.get(10, TimeUnit.SECONDS));// wait for a period of time
        executorService.shutdown();
    }
}
