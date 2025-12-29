package Extras.Threads.Homework.Level_3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor_Task {
    static class ProbeTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Probing end point for updates..");
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> handle = executor.scheduleAtFixedRate(ProbeTask::new, 0, 2, TimeUnit.SECONDS);
        executor.schedule(() ->{
            System.out.println("10 seconds passed, stopping the probing task.");
            handle.cancel(true);
            executor.shutdown();
        }, 10, TimeUnit.SECONDS
        );
    }
}
