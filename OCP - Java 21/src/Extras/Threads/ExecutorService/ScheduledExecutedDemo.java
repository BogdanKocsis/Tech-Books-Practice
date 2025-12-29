package Extras.Threads.ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * A demonstration of using a scheduled executor service to execute tasks at fixed intervals.
 * The scheduled executor service allows scheduling tasks to run after a delay or periodically.
 */

public class ScheduledExecutedDemo {
    static class ProbeTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Probing end point for updates..");
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new ProbeTask(), 1000, 2000, TimeUnit.MILLISECONDS);

        try {
            if (!scheduledExecutorService.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                scheduledExecutorService.shutdown();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
