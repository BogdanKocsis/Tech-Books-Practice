package Chapter_13_Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.*;

public class Review_Questions {
    public static class Bank {
        private Lock vault = new ReentrantLock();
        private int total = 0;

        public void deposit(int value) {
            try {
                vault.tryLock();
                total += value;
            } finally {
                vault.unlock();
            }
        }
    }

    public class Flavors {
        private static int counter;

        public static void countIceCreamFlavors() {
            counter = 0;
            Runnable task = () -> counter++;
            LongStream.range(0, 500)
                    .forEach(m -> Thread.ofPlatform()
                            .priority(1)
                            .unstarted(task)
                            .run());
            System.out.println(counter);
        }
    }

    public static class BedTime {
        private AtomicInteger s1 = new AtomicInteger(0); // w1
        private int s2 = 0;

        private void countSheep() throws InterruptedException {
            try (var service = Executors.newSingleThreadExecutor()) { // w2
                for (int i = 0; i < 100; i++)
                    service.execute(() -> {
                        s1.getAndIncrement();
                        s2++;
                    }); // w3
                Thread.sleep(60_000);
                System.out.println(s1 + " " + s2);
            }
        }
    }

    public static void performCount(int animal) {
        // IMPLEMENTATION OMITTED
    }
    public static void printResults(Future<?> f) {
        try {
            System.out.println(f.get(1, TimeUnit.DAYS)); // o1
        } catch (Exception e) {
            System.out.println("Exception!");
        }
    }

    public static void main(String[] args) throws
            InterruptedException, ExecutionException {

        // Q2
        var bank = new Bank();
        IntStream.range(1, 10).parallel().forEach(s -> bank.deposit(s));
        System.out.println(bank.total);

        // Q5
        var value1 = new AtomicLong(0);
        final long[] value2 = {0};
        IntStream.iterate(1, i -> 1).limit(100).parallel()
                .forEach(i -> value1.incrementAndGet());
        IntStream.iterate(1, i -> 1).limit(100).parallel()
                .forEach(i -> ++value2[0]);
        System.out.println(value1 + " " + value2[0]);

        //Q6
        var data = List.of(2, 5, 1, 9, 8);
        data.stream().parallel()
                .mapToInt(s -> s)
//              .peek(System.out::print)
                .forEachOrdered(System.out::print);
        System.out.println();

        //Q8
        Flavors.countIceCreamFlavors();

        //Q10
        SequencedCollection<Integer> lions = new ArrayList<>(List.of(1, 2, 3));
        SequencedCollection<Integer> tigers = new CopyOnWriteArrayList<>(lions);
        Set<Integer> bears = new ConcurrentSkipListSet<>();
        bears.addAll(lions);
        for (Integer item : tigers) tigers.add(4); // x1
        for (Integer item : bears) bears.add(5);   // x2
        System.out.println(lions.size() + " " + tigers.size()
                + " " + bears.size());

        //Q11
        Integer i1 = List.of(1, 2, 3, 4, 5).stream().findAny().get();
        synchronized (i1) { // y1
            Integer i2 = List.of(6, 7, 8, 9, 10)
                    .parallelStream()
                    .sorted()
                    .findAny().get(); // y2
            System.out.println(i1 + " " + i2);
        }

        //Q15
        var cats = Stream.of("leopard", "lynx", "ocelot", "puma")
                .parallel();
        var moreBears = Stream.of("panda", "grizzly", "polar").parallel();
        var moreData = Stream.of(cats, moreBears).flatMap(s -> s)
                .collect(Collectors.groupingByConcurrent(
                        s -> !s.startsWith("p")));
        System.out.println(moreData.get(false).size()
                + " " + moreData.get(true).size());

        //Q21
        var test = List.of(List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6));
        test.stream() // p1
                .flatMap(s -> s.stream())
                .findFirst()  // p2
                .ifPresent(System.out::print);
        System.out.println();
        var test2 = List.of(List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6));
        test2.parallelStream() // p1
                .flatMap(s -> s.stream())
                .findFirst()  // p2
                .ifPresent(System.out::print);

        //Q22
        new BedTime().countSheep();

        //Q25
        final var r = new ArrayList<Future<?>>();
        try (var s = Executors.newSingleThreadExecutor()) {
            for (int i = 0; i < 10; i++) {
                final int animal = i;
                r.add(s.submit(() -> performCount(animal))); // o2
            }
            r.forEach(f -> printResults(f));
        }
    }
}
