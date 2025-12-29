package Chapter_10_Streams;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * ================================================================================================================
 *                                      Mapping Methods Between Types of Streams
 * ================================================================================================================
 * | Source Stream | To create Stream     | To create DoubleStream | To create IntStream | To create LongStream |
 * |----------------|----------------------|------------------------|--------------------|----------------------|
 * | Stream<T>      | map()               | mapToDouble()          | mapToInt()         | mapToLong()          |
 * | DoubleStream   | mapToObj()          | map()                  | mapToInt()         | mapToLong()          |
 * | IntStream      | mapToObj()          | mapToDouble()          | map()              | mapToLong()          |
 * | LongStream     | mapToObj()          | mapToDouble()          | mapToInt()         | map()                |
 * ================================================================================================================
 **/


/**
 * ================================================================================================================================================
 *                                              Mapping Function Types Between Stream Variants
 * ===============================================================================================================================================
 * | Source Stream | To create Stream         | To create DoubleStream         | To create IntStream            | To create LongStream           |
 * |----------------|--------------------------|--------------------------------|--------------------------------|--------------------------------|
 * | Stream<T>      | Function<T, R>           | ToDoubleFunction<T>            | ToIntFunction<T>               | ToLongFunction<T>              |
 * | DoubleStream   | DoubleFunction<R>        | DoubleUnaryOperator            | DoubleToIntFunction            | DoubleToLongFunction           |
 * | IntStream      | IntFunction<R>           | IntToDoubleFunction            | IntUnaryOperator               | IntToLongFunction              |
 * | LongStream     | LongFunction<R>          | LongToDoubleFunction           | LongToIntFunction              | LongUnaryOperator              |
 * =================================================================================================================================================
 */

/**
 * =============================================================================================
 *                                Optional Types for Primitives
 * =============================================================================================
 * |                            | OptionalDouble      | OptionalInt       | OptionalLong       |
 * |-----------------------------|--------------------|-------------------|--------------------|
 * | Getting as primitive        | getAsDouble()      | getAsInt()        | getAsLong()        |
 * | orElseGet() parameter type  | DoubleSupplier     | IntSupplier       | LongSupplier       |
 * | Return type of max() / min()| OptionalDouble     | OptionalInt       | OptionalLong       |
 * | Return type of sum()        | double             | int               | long               |
 * | Return type of average()    | OptionalDouble     | OptionalDouble    | OptionalDouble     |
 * =============================================================================================
 */


public class Primitive_Streams {

    private static int range(IntStream ints){
        IntSummaryStatistics stats = ints.summaryStatistics();
        if(stats.getCount() == 0) throw new RuntimeException();
        return stats.getMax() - stats.getMin();
    }

    public static void main(String[] args) {
        // Primitive Streams: IntStream, LongStream, DoubleStream
        // IntStream(for int, short, byte and char)

        Stream<Integer> stream = Stream.of(1, 2, 3);
        System.out.println("Sum: " + stream.mapToInt(x -> x).sum());

        IntStream intStream = IntStream.of(1, 2, 3);
        OptionalDouble average = intStream.average();
        System.out.println("Average: " + average.orElseGet(() -> Double.NaN));

        IntStream range = IntStream.range(1, 6);
        range.forEach(System.out::println);

        // DoubleStream(for float and double)
        DoubleStream oneValue = DoubleStream.of(3.14);
        oneValue.forEach(System.out::println);

        DoubleStream varargs = DoubleStream.of(1.0, 1.5, 2.0, 2.5);
        varargs.forEach(System.out::println);

        var random = DoubleStream.generate(Math::random);
        var fractions = DoubleStream.iterate(.5, d -> d / 2);
        random.limit(3).forEach(System.out::println);
        fractions.limit(3).forEach(System.out::println);

        // Mapping to primitive streams
        Stream<String> objStream = Stream.of("penguin", "fish", "cat");
        IntStream intStream1 = objStream.mapToInt((String::length));
        intStream1.forEach(System.out::println);

        // Optional primitive types
        LongStream longs = LongStream.of(5, 10);
        long sum = longs.sum();
        System.out.println("Sum of longs: " + sum);
//        DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
//        OptionalDouble min = doubles.min(); // runs infinitely

        IntStream empty = IntStream.empty();
        try {
            System.out.println("Range of empty: " + range(empty));
        } catch (RuntimeException e) {
            System.out.println("Cannot compute range of empty stream");
        }

        IntStream numbers = IntStream.of(7, 2, 10, 4);
        System.out.println("Range of numbers: " + range(numbers));

    }
}
