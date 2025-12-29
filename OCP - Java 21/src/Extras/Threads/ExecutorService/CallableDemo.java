package Extras.Threads.ExecutorService;

import java.util.concurrent.*;

/**
 * A demonstration of using Callable with ExecutorService to return a value from a task.
 * The Callable interface allows tasks to return results and throw checked exceptions.
 */
public class CallableDemo {
    static class ReturnValueTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(5000);
            return 12;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            Future<Integer> result = executorService.submit(new ReturnValueTask());

            System.out.println(result.get());

            result.cancel(true); // Method to cancel the task

            boolean cancelled = result.isCancelled(); // Method to check if the task was cancelled
            boolean done = result.isDone(); // Method to check if the task is completed
            System.out.println("Cancelled: " + cancelled);
            System.out.println("Done: " + done);
            System.out.println("Main thread finished execution.");
        }
    }
}
