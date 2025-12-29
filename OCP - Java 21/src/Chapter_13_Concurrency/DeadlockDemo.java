package Chapter_13_Concurrency;

import java.util.concurrent.TimeUnit;

public class DeadlockDemo {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Lock 1 is acquired");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            synchronized (lock2) {
                System.out.println("Block will never be executed");
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Lock 2 is acquired");
                synchronized (lock1) {
                    System.out.println("Block will never be executed");
                }
            }
        }).start();
    }
}
