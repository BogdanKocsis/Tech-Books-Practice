package Chapter_10_Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Advanced_Pipelines_Concepts {
    private static void threeDigit(Optional<Integer> number) {
        number.map(n -> "" + n)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        threeDigit(Optional.of(123));
        threeDigit(Optional.of(12));
        threeDigit(Optional.empty());

        // using basic collectors
        var ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result);

        ohMy = Stream.of("lions", "tigers", "bears");
        TreeSet<String> anotherResult = ohMy.filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(anotherResult);

        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        List<String> mutableList = ohMy1.collect(Collectors.toList()); // mutable list

        mutableList.add("lions");

        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        List<String> immutableList = ohMy2.toList(); // immutable list
        //immutableList.add("lions"); // UnsupportedOperationException

        ohMy = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy.collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map);

        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map2 = ohMy.collect(groupingBy(String::length, Collectors.toSet()));
        System.out.println(map2);

        ohMy = Stream.of("lions", "tigers", "bears");
        var map3 = ohMy.collect(groupingBy(String::length,
                mapping(s -> s.charAt(0), minBy((a, b) -> a - b))));
        System.out.println(map3);

        // spliterator
        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-",
                "mouse-");

        Spliterator<String> originalBagOfFood = stream.spliterator();
        Spliterator<String> emmasBagOfFood = originalBagOfFood.trySplit();
        emmasBagOfFood.forEachRemaining(System.out::print);
        System.out.println();

        Spliterator<String> jillsBagOfFood = originalBagOfFood.trySplit();
        jillsBagOfFood.tryAdvance(System.out::print);
        System.out.println();
        jillsBagOfFood.forEachRemaining(System.out::print);
        System.out.println();
        originalBagOfFood.forEachRemaining(System.out::print);
    }
}
