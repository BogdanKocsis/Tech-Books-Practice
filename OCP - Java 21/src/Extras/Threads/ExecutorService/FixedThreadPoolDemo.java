package Extras.Threads.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * A demonstration of using a fixed thread pool to execute multiple tasks concurrently.
 * The fixed thread pool limits the number of concurrent threads to a specified maximum.
 */

public class FixedThreadPoolDemo {

    static class Work implements Runnable {
        private final int workId;

        public Work(int workId) {
            this.workId = workId;
        }

        @Override
        public void run() {
            System.out.println("Task ID: " + workId + " executed by " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            for (int i = 0; i < 7; i++) {
                executorService.execute(new Work(i));
            }
        }
    }
}
