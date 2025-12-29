package Extras.Threads.ConcurrentCollection;

import java.util.concurrent.Exchanger;

/**
 * Exchanger is a synchronization point at which threads can pair and swap
 * elements within pairs. Each thread presents some object on entry to the
 * exchange method, matches with a partner thread, and receives its partner's
 * object on return.
 * * This is useful in applications such as genetic algorithms and pipeline designs.
 *
 * Queue vs Exchanger:
 * - Queue: Multiple producers and consumers can add and remove items concurrently.
 * - Exchanger: Specifically designed for two threads to exchange data directly.
 */

public class ExchangerDemo {
    record FirstThread(Exchanger<Integer> exchanger) implements Runnable {

        @Override
            public void run() {
                int dataToSend = 42;
                try {
                    System.out.println("FirstThread: Sending data: " + dataToSend);
                    Integer receivedData = exchanger.exchange(dataToSend);
                    System.out.println("FirstThread: Received data: " + receivedData);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    record SecondThread(Exchanger<Integer> exchanger) implements Runnable {

        @Override
            public void run() {
                try {
                    Thread.sleep(3000); // Simulate some processing delay
                    int dataToSend = 84;
                    System.out.println("SecondThread: Sending data: " + dataToSend);
                    Integer receivedData = exchanger.exchange(dataToSend);
                    System.out.println("SecondThread: Received data: " + receivedData);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        Thread t1 = new Thread(new FirstThread(exchanger));
        Thread t2 = new Thread(new SecondThread(exchanger));

        t1.start();
        t2.start();
    }
}
