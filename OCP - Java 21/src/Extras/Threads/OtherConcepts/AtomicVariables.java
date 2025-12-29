package Extras.Threads.OtherConcepts;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariables {
    private static int counter = 0;
    private  static final AtomicInteger counterAtomic = new AtomicInteger(0);
    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                //counter++;
                counterAtomic.incrementAndGet();
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                //counter++;
                counterAtomic.incrementAndGet();
            }
        });
        one.start();
        two.start();
        try {
            one.join();
            two.join();
            System.out.println("Final Counter Value: " + counterAtomic.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
