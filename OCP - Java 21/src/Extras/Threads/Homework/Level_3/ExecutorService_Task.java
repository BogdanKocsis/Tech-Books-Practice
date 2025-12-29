package Extras.Threads.Homework.Level_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorService_Task {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing Task " + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " has completed Task " + taskId);
            });
        }

        executor.shutdown();

        try {

            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Time is up! Forcing shutdown...");
                executor.shutdownNow();
            } else {
                System.out.println("All tasks completed successfully.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread is exiting.");

    }
}