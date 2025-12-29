package Extras.Threads.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ideal Thread Pool Size
 * For CPU-intensive tasks, the optimal number of threads is typically equal to the number of available CPU cores.
 * This is because CPU-bound tasks require significant processing power, and having more threads than CPU cores
 * can lead to excessive context switching, which degrades performance.
 * For I/O-bound tasks, the optimal number of threads can be higher than the number of CPU cores,
 * as these tasks often spend time waiting for I/O operations to complete, allowing other threads to utilize the CPU during these wait times.
 */

public class CPUIntensiveTask {
    static class CPUTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Some CPU intensive work is being performed by " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        try (ExecutorService executorService = Executors.newFixedThreadPool(cores)) {
            System.out.println("Created thread pool with " + cores + " cores.");

            for (int i = 0; i < 20; i++) {
                executorService.execute(new CPUTask());
            }
        }
    }
}
