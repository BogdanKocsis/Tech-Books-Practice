package Chapter_10_Streams;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.*;

public class Review_Questions {
    public static void main(String[] args) {

        // Q1
        var stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));

        // Q2
        /*
        Predicate<String> predicate = s -> s.startsWith("g");
        var stream1 = Stream.generate(() -> "growl!");
        var stream2 = Stream.generate(() -> "growl!");
        var b1 = stream1.anyMatch(predicate);
        var b2 = stream2.allMatch(predicate);
        System.out.println(b1 + " " + b2); // infinite stream, b1=true, b2=never ends

        */

        // Q3
        /*
        Predicate<String> predicate = s -> s.length() > 3;
        var anotherStream = Stream.iterate("-",
                s -> !s.isEmpty(), (s) -> s + s);
        var b1 = anotherStream.noneMatch(predicate);
        var b2 = anotherStream.anyMatch(predicate);
        System.out.println(b1 + " " + b2); // exception, stream consumed

         */

        // Q5
        double result = LongStream.of(6L, 8L, 10L)
                .mapToInt(x -> (int) x)
                .boxed()
                .collect(Collectors.groupingBy(x -> x))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x -> x));

        double anotherResult = LongStream.of(6L, 8L, 10L)
                .mapToInt(x -> (int) x)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.toSet()))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x -> x));
        System.out.println(result);
        System.out.println(anotherResult);

        // Q6
        var s = Stream.generate(() -> "meow");
        var match = s.allMatch(String::isEmpty);
        System.out.println(match);

        // Q9
        var longStream = LongStream.of(1, 2, 3);
        var opt = longStream.map(n -> n * 10)
                .filter(n -> n < 5).findFirst();
        opt.ifPresent(System.out::println);

        // Q11
        var res = Stream.iterate(1, x -> ++x)
                .limit(5).map(x -> "" + x)
                .collect(Collectors.joining());
        System.out.println(res);

        // Q16
        Predicate<String> empty = String::isEmpty;
        Predicate<String> notEmpty = empty.negate();
                var value = Stream.generate(() -> "")
           .limit(10)
           .filter(notEmpty)
           .collect(Collectors.groupingBy(k -> k))
           .entrySet()
           .stream()
           .map(Map.Entry::getValue)
           .flatMap(Collection::stream)
           .collect(Collectors.partitioningBy(notEmpty));
        System.out.println(value);

        // Q17
        var text = DoubleStream.of(1.2, 2.4);
        text.peek(System.out::println).filter(x -> x> 2).count();

        // Q18
        
    }
}
