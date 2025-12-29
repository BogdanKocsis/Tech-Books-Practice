package Extras.Threads.ThreadSynchronisation;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
    static class Worker {
        private int sequence = 0;
        private final Integer top;
        private final Integer bottom;
        private final List<Integer> container;
        private final Object lock = new Object();

        public Worker(Integer bottom, Integer top) {
            this.bottom = bottom;
            this.top = top;
            this.container = new ArrayList<>();
        }

        public void produce() throws InterruptedException {
            synchronized (lock) {
                while (true) {
                    if (container.size() == top) {
                        System.out.println("Container full, waiting for consumer to consume");
                        lock.wait();
                    } else {
                        System.out.println(sequence + " Added to container");
                        container.add(sequence++);
                        lock.notify();
                    }
                    Thread.sleep(500);
                }
            }
        }

        public void consume() throws InterruptedException {
            synchronized (lock) {
                while (true) {
                    if (container.size() == bottom) {
                        System.out.println("Container empty, waiting for producer to produce");
                        lock.wait();
                    } else {
                        System.out.println(container.removeFirst() + " Removed from container");
                        lock.notify();
                    }
                    Thread.sleep(500);
                }
            }

        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker(0, 5);
        Thread producer = new Thread(() -> {
            try {
                worker.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}
