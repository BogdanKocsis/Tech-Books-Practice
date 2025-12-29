package Extras.Threads.Locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock is a synchronization mechanism that allows a thread to acquire the same lock multiple times without causing a deadlock.
 * This is particularly useful in scenarios where methods that require locking call other methods that also require the same lock.
 * Lock Fairness can be configured to ensure that the longest-waiting thread gets access to the lock next.
 * When they are needed? They are needed in complex synchronization scenarios where intrinsic locks (synchronized blocks/methods) are insufficient.
 *
 */
public class ReentrantLockDemo {
    private final ReentrantLock lock = new ReentrantLock();
    private int sharedData = 0;

    public void methodA() {
        lock.lock();
        try {
            sharedData++;
            System.out.println("Method A - Shared Data: " + sharedData);
            methodB(); // Reentrant call
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            sharedData--;
            System.out.println("Method B - Shared Data: " + sharedData);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();

        for (int i = 0; i < 5; i++) {
            new Thread(demo::methodA).start();
        }
    }

}
