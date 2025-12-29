package Extras.Threads.Homework.Level_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock_Task {
    private int sequence = 0;
    private static final int TOTAL = 10;

    private final List<Integer> container = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public void produce() throws InterruptedException {
        for (int i = 0; i < TOTAL; i++) {
            lock.lock();
            try {
                while (container.size() == TOTAL) {
                    System.out.println("Container full, waiting for consumer to consume");
                    notFull.await();
                }
                System.out.println(sequence + " Added to container");
                container.add(sequence++);
                Thread.sleep(200);
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (container.isEmpty()) {
                    System.out.println("Container empty, waiting for producer to produce");
                    notEmpty.await();
                }
                System.out.println(container.removeFirst() + " Removed from container");
                Thread.sleep(500);
                notFull.signal();

                if (container.isEmpty()) {
                    System.out.println("Container empty after consumption, notifying producer to produce");
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock_Task level2 = new ReentrantLock_Task();

        Thread producer = new Thread(() -> {
            try {
                level2.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    level2.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}
