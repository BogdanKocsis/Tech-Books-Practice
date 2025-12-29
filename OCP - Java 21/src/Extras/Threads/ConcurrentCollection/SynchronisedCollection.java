package Extras.Threads.ConcurrentCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Most of the collections classes in Java are not synchronized by default.(not thread-safe)
 * To make them synchronized, we can use Collections.synchronizedXXX() methods.
 */
public class SynchronisedCollection {
    public static void main(String[] args) throws InterruptedException {
        // List<Integer> list = new ArrayList<>();
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread one = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(list.size());
    }
}
