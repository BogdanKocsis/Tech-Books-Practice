package Extras.Threads.ConcurrentCollection;

import java.util.concurrent.CountDownLatch;

/**
 * A CountdownLatch is a synchronization aid that allows one or more threads to wait until
 * a set of operations being performed in other threads completes.
 * It is initialized with a given count, and threads can call await() to wait until the count reaches zero.
 * Other threads can call countDown() to decrement the count.
 * Is it similar to join(), but join() is used to wait for a specific thread to finish,
 * whereas CountdownLatch can be used to wait for multiple threads to complete their tasks.
 * Can we reset a CountdownLatch? No, once the count reaches zero, it cannot be reset.
 */
public class CountdownLatchDemo {
    static class Chef implements Runnable {
        private final String name;
        private final String dish;
        private final CountDownLatch latch;

        public Chef(String name, String dish, CountDownLatch latch) {
            this.name = name;
            this.dish = dish;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " is preparing " + dish);
                Thread.sleep(2000); // Simulate time taken to prepare the dish
                System.out.println(name + " has finished preparing " + dish);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown(); // Decrement the count of the latch
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int numberOfChefs = 3;
        CountDownLatch latch = new CountDownLatch(numberOfChefs);

        new Thread(new Chef("Chef A", "Pizza", latch)).start();
        new Thread(new Chef("Chef B", "Pasta", latch)).start();
        new Thread(new Chef("Chef C", "Salad", latch)).start();

        latch.await();

        System.out.println("All dishes are prepared! Time to serve the meal.");
    }
}
