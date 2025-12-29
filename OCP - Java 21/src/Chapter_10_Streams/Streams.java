package Chapter_10_Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ====================================================================================
 * Terminal Stream Operations
 * ================================================================
 * | Method          | What happens for infinite streams | Return value   | Reduction |
 * |-----------------|-----------------------------------|----------------|------------|
 * | count()         | Does not terminate                | long           | Yes        |
 * | min()           | Does not terminate                | Optional<T>    | Yes        |
 * | max()           | Does not terminate                | Optional<T>    | Yes        |
 * | findAny()       | Terminates                        | Optional<T>    | No         |
 * | findFirst()     | Terminates                        | Optional<T>    | No         |
 * | allMatch()      | Sometimes terminates              | boolean        | No         |
 * | anyMatch()      | Sometimes terminates              | boolean        | No         |
 * | noneMatch()     | Sometimes terminates              | boolean        | No         |
 * | forEach()       | Does not terminate                | void           | No         |
 * | reduce()        | Does not terminate                | Varies         | Yes        |
 * | collect()       | Does not terminate                | Varies         | Yes        |
 * =====================================================================================
 */


public class Streams {
    public static void main(String[] args) {

        // Finite Streams
        Stream<String> emptyStream = Stream.empty();
        Stream<Integer> singleElementStream = Stream.of(42);
        Stream<Integer> fromArrayStream = Stream.of(1, 2, 3, 4, 5);

        System.out.println("Empty Stream:");
        emptyStream.forEach(System.out::println);
        System.out.println("Single Element Stream:");
        singleElementStream.forEach(System.out::println);
        System.out.println("From Array Stream:");
        fromArrayStream.forEach(number -> System.out.print(number + " "));
        System.out.println();

        // Collection to a stream
        var list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> fromList = list.stream();
        System.out.println("From List Stream:");
        fromList.forEach(number -> System.out.print(number + " "));
        System.out.println();

        Stream<Integer> oddNumberUnder100 = Stream.iterate(1, n -> n < 100, n -> n + 2);
        System.out.println("Odd Numbers Under 100:");
        oddNumberUnder100.forEach(number -> System.out.print(number + " "));
        System.out.println();

        // Terminal operation example
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count());

        s = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println);

        s = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");

        s.findAny().ifPresent(System.out::println);
        infinite.findAny().ifPresent(System.out::println);

        var anoterList = List.of("monkey", "2", "chimp");
        infinite = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(anoterList.stream().anyMatch(pred));
        System.out.println(anoterList.stream().allMatch(pred));
        System.out.println(anoterList.stream().noneMatch(pred));
        System.out.println(infinite.anyMatch(pred));

        Stream<String> letters = Stream.of("w", "o", "l", "f");
        String word = letters.reduce("", (f, c) -> f + c);
        System.out.println(word);

        Stream<Integer> numbers = Stream.of(3, 5, 6);
        System.out.println(numbers.reduce(1, (a, b) -> a * b));

        letters = Stream.of("w", "o", "l", "f");
        StringBuilder word2 = letters.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(word2);

        letters = Stream.of("w", "o", "l", "f");
        Set<String> set = letters.collect(Collectors.toSet());
        System.out.println(set);

        s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m")).forEach(System.out::println);

        s = Stream.of("duck", "duck", "duck", "goose");
        s.distinct().forEach(System.out::print);
        System.out.println();

        Stream<Integer> nums = Stream.iterate(1, n -> n + 1);
        nums.skip(5).limit(2).forEach(System.out::print);
        System.out.println();

        s = Stream.of("monkey", "gorilla", "bonobo");
        s.map(String::length).forEach(System.out::print);
        System.out.println();


        List<String> zero = List.of();
        var one = List.of("Bonobo");
        var two = List.of("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(m -> m.stream()).forEach(System.out::println);


        s = Stream.of("brown-", "bear-", "grizzly-");
        s.sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();

        s = Stream.of("black bear", "brown bear", "grizzly");
        long count = s.filter(p -> p.startsWith("g")).peek(System.out::println).count();
        System.out.println(count);
    }
}
