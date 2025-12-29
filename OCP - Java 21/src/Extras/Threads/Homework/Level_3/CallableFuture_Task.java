package Extras.Threads.Homework.Level_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableFuture_Task {
    record FactorialTask(int number) implements Callable<Long> {

        @Override
            public Long call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " is calculating factorial of " + number);
                long result = 1;
                for (int i = 1; i <= number; i++) {
                    result *= i;
                    Thread.sleep(100);
                }
                System.out.println(Thread.currentThread().getName() + " has completed calculation of factorial of " + number);
                return result;
            }
        }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<Long>> list = new ArrayList<>();

        int[] numbers = {3, 4, 5, 6};
        for (int number : numbers) {
            Future<Long> future = executor.submit(new FactorialTask(number));
            list.add(future);
        }

        System.out.println("Retrieving results:");
        for (int i = 0; i < numbers.length; i++) {
            try{
                Long result = list.get(i).get();
                System.out.println("Factorial of " + numbers[i] + " is " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();

            }
        }
        executor.shutdown();
    }
}
