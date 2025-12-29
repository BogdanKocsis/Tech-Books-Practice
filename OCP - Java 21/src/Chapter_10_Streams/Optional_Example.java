package Chapter_10_Streams;

import Chapter_5_Methods.Methods;

import java.util.Optional;
import java.util.stream.Stream;

public class Optional_Example {

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0)
            return Optional.empty();
        int sum = Methods.sum(scores);
        return Optional.of(sum * 1.0 / scores.length);
    }

    public static void main(String[] args) throws Throwable {

        Optional<Double> average = average(90, 100);
        average.ifPresent(System.out::println);
        System.out.println(average.orElse(0.0));

        Optional<Double> opt = average();
        //System.out.println(opt.get()); // NoSuchElementException
        Optional.ofNullable(null);
        Optional.empty();

        Optional o = Optional.of(1);
        System.out.println(o.isEmpty());
        System.out.println(o.isPresent());
        o.ifPresent(System.out::println);
        System.out.println(o.or(() -> Optional.of(2)));
        System.out.println(o.orElse(3));
        System.out.println(o.orElseGet(() -> 4));
        System.out.println(o.orElseThrow());
        System.out.println(o.orElseThrow(Exception::new));


        System.out.println(average.orElse(Double.NaN));
        System.out.println(average.orElseGet(() -> Math.random()));
        System.out.println(average.orElseThrow());
    }
}
