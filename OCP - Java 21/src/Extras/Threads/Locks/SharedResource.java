package Extras.Threads.Locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock allows multiple threads to read a shared resource concurrently while ensuring exclusive access for write operations.
 * This is particularly useful in scenarios where read operations are more frequent than write operations,
 * as it improves concurrency and performance by allowing multiple readers to access the resource simultaneously.
 * ReadWriteLock vs ReentrantLock: While ReentrantLock allows only one thread to access a resource at a time (either for reading or writing),
 * ReadWriteLock differentiates between read and write access, allowing multiple threads to read concurrently while ensuring exclusive access for writes.
 * When to use ReadWriteLock: Use ReadWriteLock in scenarios where read operations significantly outnumber write operations,
 * such as in caching mechanisms, configuration settings, or shared data structures that are frequently read but infrequently modified.
 *
 */
public class SharedResource {
    private int counter = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void increment() {
        lock.writeLock().lock();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " writes : " + counter);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void getValue() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reads : " + counter);
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        for (int i = 0; i < 2; i++) {
            Thread readerThread = new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    sharedResource.getValue();
                }
            });
            readerThread.setName("ReaderThread-" + (i + 1));
            readerThread.start();
        }

        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.increment();
            }
        });
        writerThread.setName("Writer Thread");
        writerThread.start();
    }
}
