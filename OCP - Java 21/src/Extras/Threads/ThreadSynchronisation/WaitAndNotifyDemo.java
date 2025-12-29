package Extras.Threads.ThreadSynchronisation;

/**
 * Demonstrates the use of wait() and notify() for inter-thread communication.
 * One thread waits for a notification from another thread before proceeding.
 * When the first thread calls wait(), it releases the lock on the shared object and enters a waiting state.
 * The second thread, after acquiring the lock, calls notify() to wake up the waiting thread.
 * Wait vs sleep:
 * - wait(): Releases the lock and waits until notified. It must be called within a synchronized block.
 * - sleep(): Does not release the lock and simply pauses the thread for a specified duration
 */

public class WaitAndNotifyDemo {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread two = new Thread(() -> {
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        one.start();
        two.start();
    }

    private static void one() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Hello from method one...");
            LOCK.wait();
            System.out.println("Back again in method one");
        }
    }

    private static void two() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Hello from method two...");
            LOCK.notify();
            System.out.println("Hello from method two after notify...");
        }
    }
}
