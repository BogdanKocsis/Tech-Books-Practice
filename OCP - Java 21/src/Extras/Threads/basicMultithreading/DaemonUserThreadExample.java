package Extras.Threads.basicMultithreading;

/**
 * Two categories of threads:
 * 1. User Threads: These are the standard threads that perform the main tasks of an application.
 * The JVM waits for all user threads to complete before terminating the program.
 * 2. Daemon Threads: These are background threads that provide services to user threads.
 * The JVM does not wait for daemon threads to finish; it terminates them when all user threads have completed.
 * <p>
 * Daemon threads are typically used for tasks such as garbage collection, background monitoring,
 * or other low-priority tasks that should not prevent the application from exiting.
 */

public class DaemonUserThreadExample {
    public static void main(String[] args) {
        Thread backgroundThread = new Thread(new DaemonHelper());
        Thread userThread = new Thread(new UserThreadHelper());

        backgroundThread.setDaemon(true);

        backgroundThread.start();
        userThread.start();
    }

    static class DaemonHelper implements Runnable {
        @Override
        public void run() {
            int count = 0;
            while (count < 500) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                System.out.println("Daemon Helper running...");

            }
        }
    }

    static class UserThreadHelper implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("User Thread completed its work.");
        }
    }
}
