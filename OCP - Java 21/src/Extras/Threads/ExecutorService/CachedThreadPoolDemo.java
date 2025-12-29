package Extras.Threads.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A demonstration of using a cached thread pool to execute multiple tasks concurrently.
 * The cached thread pool creates new threads as needed and reuses previously constructed threads when available.
 */

public class CachedThreadPoolDemo {
    static class TaskOne implements Runnable {
        private final int taskId;

        public TaskOne(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("TaskOne ID: " + taskId + " executed by " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 1000; i++) {
                executorService.execute(new TaskOne(i));
            }
        }
    }
}
