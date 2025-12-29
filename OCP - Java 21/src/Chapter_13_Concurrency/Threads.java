package Chapter_13_Concurrency;

public class Threads {
    public static class Runner implements Runnable {
        public void run() {
            System.out.println("Running...");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner() {
        });
        Thread t2 = new MyThread();
        Thread t3 = new Thread(() -> System.out.println("Running in lambda..."));

        t1.setDaemon(true); // JVM will terminate if only daemon threads are running

        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println("Waiting for t3 to finish...");
            t3.join(); // Wait for t3 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
