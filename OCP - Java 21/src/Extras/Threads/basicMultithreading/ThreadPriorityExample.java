package Extras.Threads.basicMultithreading;

/**
 * Each thread has certain priority and under normal circumstance the thread with higher priority gets to run on the CPU.
 * Priority value from 1(MIN_PRIORITY) to 10(MAX_PRIORITY) can be assigned to any thread. (5 is NORM_PRIORITY)
 * Threads of the same priority value are executed in FIFO manner.
 * Thread priority = hint (suggestion), not command!
 */

public class ThreadPriorityExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
//        System.out.println(Thread.currentThread().getPriority());


        System.out.println(Thread.currentThread().getName() + " says Hi!");

        Thread one = new Thread(() -> {
            System.out.println("Thread one says Hi as well!");
        });

        one.setPriority(Thread.MAX_PRIORITY);
        one.start();
    }
}
