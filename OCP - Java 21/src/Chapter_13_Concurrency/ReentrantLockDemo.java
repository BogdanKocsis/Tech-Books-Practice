package Chapter_13_Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLockDemo {
    private static int counter;
    private Lock lock = new ReentrantLock();

    public void incrementWithLock() {
        try {
            lock.lock();
            counter++;
        } finally {
            lock.unlock();
        }
    }

    private static void terminateExecutorService(ExecutorService executor) throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.SECONDS);
        executor.shutdownNow();
    }

    public static void main(String[] args) throws InterruptedException {
        var thisInstance = new ReentrantLockDemo();
        var executorService = Executors.newFixedThreadPool(4);
        IntStream.range(0, 10000).forEach((i) -> executorService.execute(thisInstance::incrementWithLock));
        terminateExecutorService(executorService);
        System.out.println("Final Counter Value: " + counter);
    }
}
