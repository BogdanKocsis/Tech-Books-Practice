package Chapter_13_Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * A CyclicBarrier supports an optional Runnable command that is run once per barrier point, after the last thread
 * in the party arrives, but before any threads are released. This barrier action is useful for updating shared-state
 * before any of the parties continue.
 */

public class CyclicBarrierDemo {
    private static final int NUM_OF_THREADS = 4;
    private static final int NUM_TO_GENERATE = 3;
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final Random RANDOM = new Random();

    private static CyclicBarrier barrier;
    private List<Integer> generatedNumbers = new ArrayList<>();

    private void numberGenerationCallback() {
        System.out.println("Callback");
        int max = generatedNumbers.stream().mapToInt(i -> i).max().getAsInt();
        System.out.println("All generated numbers: " + generatedNumbers);
        System.out.println("Max generated number: " + max);
    }

    private void generateRandomNumbers() {
        for (int i = 0; i < NUM_TO_GENERATE; i++) {
            generatedNumbers.add(RANDOM.nextInt(MAX_RANDOM_NUMBER));
        }
        try {
            System.out.println("await: " + barrier.getNumberWaiting());
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var demo = new CyclicBarrierDemo();
        barrier = new CyclicBarrier(NUM_OF_THREADS, demo::numberGenerationCallback); // callback executed when all threads have tripped

        var ex = Executors.newFixedThreadPool(NUM_OF_THREADS);
        IntStream.range(0, NUM_TO_GENERATE).forEach(i -> ex.submit(demo::generateRandomNumbers));
        System.out.println("getParties(): " + barrier.getParties());

        ex.shutdown();
    }
}
