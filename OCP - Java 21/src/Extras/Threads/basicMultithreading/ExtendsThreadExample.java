package Extras.Threads.basicMultithreading;


public class ExtendsThreadExample {
    public static void main(String[] args) {
        Thread one = new Thread1();
        Thread two = new Thread2();

        one.start();
        two.start();

    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1 - Step " + i);
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 2 - Step " + i);
            }
        }
    }
}
