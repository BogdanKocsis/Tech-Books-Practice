package Extras.Threads.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    record Task(int TaskId) implements Runnable {

        @Override
            public void run() {
                System.out.println("Task " + TaskId + " being executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            for (int i = 0; i < 5; i++) {
                executorService.execute(new Task(i));
            }
        }

    }
}
