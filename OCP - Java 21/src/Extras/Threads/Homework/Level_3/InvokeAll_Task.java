package Extras.Threads.Homework.Level_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAll_Task {
    record SquareTask(int number) implements Callable<Integer> {

        @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " calculates the square of " + number);
                Thread.sleep(500);
                return number * number;
            }
        }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            tasks.add(new SquareTask(i));
        }

        try {
            List<Future<Integer>> results = executor.invokeAll(tasks);

            System.out.println("\n=== Results ===");
            for (int i = 0; i < results.size(); i++) {
                Integer value = results.get(i).get();
                System.out.println("Result for " + (i + 1) + "^2 = " + value);
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            System.out.println("\nCompleted.");
        }
    }
}
