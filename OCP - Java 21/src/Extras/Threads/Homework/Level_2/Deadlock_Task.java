package Extras.Threads.Homework.Level_2;

public class Deadlock_Task {
    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }

    static class ThreadOne implements Runnable {
        @Override
        public void run() {
            synchronized (LOCK_A) {
                System.out.println("Thread One: Locked_A...");
                sleep(500);
                System.out.println("Thread One: Waiting for LOCK_B...");
                synchronized (LOCK_B) {
                    System.out.println("Thread One: Locked_B...");
                }
            }
        }
    }

    static class ThreadTwo implements Runnable {
        @Override
        public void run() {
            synchronized (LOCK_B) {
                System.out.println("Thread Two: Locked_B...");
                sleep(500);
                System.out.println("Thread One: Waiting for LOCK_A...");
                synchronized (LOCK_A) {
                    System.out.println("Thread One: Locked_A...");
                }
            }
        }
    }

    static class ThreadCustom implements Runnable {
        @Override
        public void run() {
            synchronized (LOCK_A) {
                System.out.println(Thread.currentThread().getName() + ": locked LOCK_A");
                sleep(500);
                synchronized (LOCK_B) {
                    System.out.println(Thread.currentThread().getName() + ": locked LOCK_B");
                    sleep(500);
                }
            }
        }
    }

    public static void main(String[] args) {

       // new Thread(new ThreadOne()).start();
       // new Thread(new ThreadTwo()).start(); // Deadlock occurs here

        new Thread(new ThreadCustom()).start(); // This thread will not cause deadlock
    }
}
