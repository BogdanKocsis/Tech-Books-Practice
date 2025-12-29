package Extras.Threads.basicMultithreading;

/**
 * Main thread as the parent thread
 * When we star a program, usually the execution begins in the main thread. This can be understood as the parent thread.
 * When we create and start other threads, thy run concurrently with the main thread unless instructed otherwise. So
 * under normal circumstances, all threads run independent of each other. No threads waits for another thread to complete its execution.
 * What is join()?
 * The join() method is used to make one thread wait for the completion of another thread. When a thread calls the join() method on another thread,
 * it pauses its execution until the thread it called join() on has finished executing.
 * Why use join()?
 * Using join() is useful when you have a scenario where one thread's execution depends on the completion of another thread.
 * By using join(), you can ensure that the dependent thread waits for the necessary thread to finish before proceeding.
 * Example:
 * In the example below, we have two threads, one and two. The main thread starts both threads and then calls join() on each of them.
 * This means that the main thread will wait for both one and two to complete their execution before printing "Done executing the threads".
 */


public class JoinThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread One - Step " + i);
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                System.out.println("Thread Two - Step " + i);
            }
        });
        System.out.println("Before starting the threads...");
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println("Done executing the threads ");
    }
}
