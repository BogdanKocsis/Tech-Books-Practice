package Extras.Threads.basicMultithreading;

/**
 * Which approach is better: extending Thread or implementing Runnable?
 * Extending Thread is simpler for quick tasks, but implementing Runnable is more flexible,
 * allowing for better resource sharing and adherence to composition over inheritance principles.
 * If we extend Thread, we cannot extend any other class, limiting our design options.
 * A class can implement multiple interfaces, allowing for more versatile designs, so implementing Runnable is often preferred in complex applications.
 */


public class RunnableThreadExample {
    public static void main(String[] args) {
        Thread one = new Thread(new ThreadOne());
        Thread two = new Thread(new ThreadTwo());
        Thread three = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    System.out.println("Thread Three: " + i);
                }
            }
        });

        one.start();
        two.start();
        three.start();

    }

    static class ThreadOne implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread One - Step " + i);
            }
        }
    }

    static class ThreadTwo implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                System.out.println("Thread Two - Step " + i);
            }
        }
    }

}