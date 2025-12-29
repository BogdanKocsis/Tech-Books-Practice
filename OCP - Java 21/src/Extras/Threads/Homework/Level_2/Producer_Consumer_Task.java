package Extras.Threads.Homework.Level_2;

import java.util.ArrayList;
import java.util.List;

public class Producer_Consumer_Task {
    private int sequence = 0;
    private static final int TOTAL = 10;
    private final Object lock = new Object();
    private final List<Integer> container = new ArrayList<>();



    public void produce() throws InterruptedException {
        synchronized (lock) {
            for (int i = 1; i <= TOTAL; i++) {
                System.out.println(sequence + " Added to container");
                container.add(sequence++);
                Thread.sleep(500);
            }
            System.out.println("Container full, notifying consumer to consume");
            lock.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (container.isEmpty()) {
                System.out.println("Container empty, waiting for producer to produce");
                lock.wait();
            }
            while (!container.isEmpty()) {
                System.out.println(container.removeFirst() + " Removed from container");
                Thread.sleep(500);
            }
        }
    }

    public static void main(String[] args) {
        Producer_Consumer_Task level2 = new Producer_Consumer_Task();

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
