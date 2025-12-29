package Chapter_8_Lambdas_and_Functional_Interfaces;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.function.*;

/**
 * ================================================================
 * Common Functional Interfaces in java.util.function
 * ================================================================
 * | Functional Interface   | Return Type | Method Name    | # of Parameters |
 * |-------------------------|-------------|----------------|-----------------|
 * | Supplier<T>             | T           | get()          | 0               |
 * | Consumer<T>             | void        | accept(T)      | 1 (T)           |
 * | BiConsumer<T, U>        | void        | accept(T, U)   | 2 (T, U)        |
 * | Predicate<T>            | boolean     | test(T)        | 1 (T)           |
 * | BiPredicate<T, U>       | boolean     | test(T, U)     | 2 (T, U)        |
 * | Function<T, R>          | R           | apply(T)       | 1 (T)           |
 * | BiFunction<T, U, R>     | R           | apply(T, U)    | 2 (T, U)        |
 * | UnaryOperator<T>        | T           | apply(T)       | 1 (T)           |
 * | BinaryOperator<T>       | T           | apply(T, T)    | 2 (T, T)        |
 * ================================================================
 **/

public class BuiltIn_Functional_Interfaces {
    public static void main(String[] args) {

        // Supplier example
        Supplier<LocalDate> s = LocalDate::now;

        LocalDate d1 = s.get();
        System.out.println(d1);

        // Consumer & BiConsumer example
        Consumer<String> c1 = System.out::println;
        c1.accept("Annie");

        var map = new HashMap<String, Integer>();
        BiConsumer<String, Integer> b1 = map::put;
        b1.accept("chicken", 7);
        System.out.println(map);

        // Predicate & BiPredicate example
        Predicate<String> p1 = String::isEmpty;
        System.out.println(p1.test("")); // true

        BiPredicate<String, String> bp1 = String::startsWith;
        System.out.println(bp1.test("chicken", "chick")); // true

        // Function & BiFunction example
        Function<String, Integer> f1 = String::length;
        System.out.println(f1.apply("cluck")); //5

        BiFunction<String, String, String> bf1 = String::concat;
        System.out.println(bf1.apply("baby ", "cluck"));

        // UnaryOperator & BinaryOperator example
        UnaryOperator<String> u1 = String::toUpperCase;
        System.out.println(u1.apply("chirp"));

        BinaryOperator<String> bo1 = String::concat;
        System.out.println(bo1.apply("baby ", "chirp"));

        Consumer<String> c2 = s1 -> System.out.print("1: " + s1);
        Consumer<String> c3 = s2 -> System.out.println(", 2: " + s2);
        Consumer<String> combined = c2.andThen(c3);
        combined.accept("Annie");

        Function<Integer, Integer> before = x -> x + 1;
        Function<Integer, Integer> after = x -> x * 2;

        Function<Integer, Integer> combined2 = after.compose(before);
        System.out.println(combined2.apply(3));

        // Functional Interface for Primitives
        BooleanSupplier supplier = () -> Math.random() < 0.5;
        System.out.println(supplier.getAsBoolean());

        DoubleSupplier doubleSupplier = Math::random;
        System.out.println(doubleSupplier.getAsDouble());
    }
}
