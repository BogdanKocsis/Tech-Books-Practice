package Extras.Threads.Homework.Level_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock_Task {
    private final List<Integer> sharedList = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public void write(int val) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": writing " + val);
            sharedList.add(val);
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + ": finished writing " + val);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock();
        }
    }

    public void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": reading list:  " + sharedList);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLock_Task task = new ReadWriteLock_Task();
        Thread writer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                task.write(i);
            }
        }, "Writer");

        // Multiple reader threads (shared access)
        Runnable readerTask = () -> {
            for (int i = 0; i < 5; i++) {
                task.read();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread reader1 = new Thread(readerTask, "Reader-1");
        Thread reader2 = new Thread(readerTask, "Reader-2");
        Thread reader3 = new Thread(readerTask, "Reader-3");

        // Start all threads
        reader1.start();
        reader2.start();
        reader3.start();
        writer.start();

        try {
            reader1.join();
            reader2.join();
            reader3.join();
            writer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nAll threads finished.");

    }
}
