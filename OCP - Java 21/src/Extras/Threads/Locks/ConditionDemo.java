package Extras.Threads.Locks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A demonstration of using Condition variables with ReentrantLock to implement a producer-consumer scenario.
 * The producer adds items to a shared buffer, and the consumer removes items from it.
 * Conditions are used to signal when the buffer is not full (for the producer) and not empty (for the consumer).
 * Conditions help manage the synchronization between producer and consumer threads effectively.
 */
public class ConditionDemo {
    private final Integer MAX_SIZE = 5;
    private final Lock lock = new ReentrantLock();
    private final Queue<Integer> buffer = new LinkedList<>();
    private final Condition bufferNotFull = lock.newCondition();
    private final Condition bufferNotEmpty = lock.newCondition();

    private void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            while (buffer.size() == MAX_SIZE) {
                bufferNotFull.await();
            }
            buffer.offer(item);
            System.out.println("Produced: " + item);
            bufferNotEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    private void consume() throws InterruptedException {
        lock.lock();
        try {
            while (buffer.isEmpty()) {
                bufferNotEmpty.await();
            }
            System.out.println("Consumed: " + buffer.poll());
            bufferNotFull.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionDemo demo = new ConditionDemo();
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    demo.produce(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    demo.consume();
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
