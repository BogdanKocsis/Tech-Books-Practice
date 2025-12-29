package Extras.Threads.ConcurrentCollection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue is a thread-safe collection that supports operations that wait for the queue to become non-empty
 * when retrieving an element, and wait for space to become available in the queue when storing an element.
 * It is useful in producer-consumer scenarios where one or more threads are producing items and
 * adding them to the queue, while one or more threads are consuming items from the queue.
 */
public class BlockingQueueDemo {
    static final int QUEUE_CAPACITY = 10;
    static BlockingQueue<Integer> taskQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i++) {
                    taskQueue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(100); // Simulate time taken to produce an item
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumerOne = new Thread(() -> {
            try {
                while (true) {
                    int task = taskQueue.take();
                    processTask(task, "Consumer One");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumerTwo = new Thread(() -> {
            try {
                while (true) {
                    int task = taskQueue.take();
                    processTask(task, "Consumer Two");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumerOne.start();
        consumerTwo.start();
    }

    private static void processTask(int task, String consumerName) throws InterruptedException {
        System.out.println("Task " + task + " processed by " + consumerName);
        Thread.sleep(1000); // Simulate time taken to process an item
        System.out.println("Task consumed: " + task + " by " + consumerName);
    }
}
