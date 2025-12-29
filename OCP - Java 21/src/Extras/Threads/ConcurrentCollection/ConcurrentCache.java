package Extras.Threads.ConcurrentCollection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  ConcurrentHashMap is a thread-safe variant of HashMap that allows concurrent access by multiple threads without the need for explicit synchronization.
 *  It achieves this by partitioning the map into segments, allowing multiple threads to read and write to different segments simultaneously.
 *  This improves performance in multi-threaded environments compared to using a synchronized HashMap, which locks the entire map for each operation.
 *  In this example, we demonstrate the use of ConcurrentHashMap to store and retrieve values in a multi-threaded environment.
 */
public class ConcurrentCache {
    private static final Map<String, String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;

            new Thread(() -> {
                String key = "Key @ " + threadNum;
                for (int j = 0; j < 3; j++) {
                    String value = getCacheValue(key);
                    System.out.println("Thread " + Thread.currentThread().getName() + ": key" + key + " => value: " + value);

                }
            }).start();

        }
    }

    private static String getCacheValue(final String key) {
        String value = cache.get(key);
        if (value == null) {
            value = computeIfAbsent(key);
            cache.put(key, value);
        }
        return value;
    }

    private static String computeIfAbsent(final String key) {
        System.out.println(key + " is absent, computing value...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Value for " + key;
    }
}
