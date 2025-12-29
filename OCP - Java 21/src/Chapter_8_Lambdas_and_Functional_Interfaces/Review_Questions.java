package Chapter_8_Lambdas_and_Functional_Interfaces;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static Chapter_8_Lambdas_and_Functional_Interfaces.Review_Questions.Hyena.testLaugh;
import static Chapter_8_Lambdas_and_Functional_Interfaces.Review_Questions.Panda.check;

public class Review_Questions {

    public static class Panda {
        int age;

        static void check(Panda panda,
                          Predicate<Panda> pred) {
            String result =
                    pred.test(panda) ? "match" : "not match";
            System.out.println(result);
        }
    }

    public void remove(List<Character> chars) {
        char end = 'z';
        Predicate<Character> predicate = c -> {
            char start = 'a';
            return start <= c && c <= end;
        };

        //char start = 'a';
        char c = 'x';
        //chars = null;
        System.out.println(predicate.test(c));
    }

    public static class Hyena {
        private int age = 1;

        static void testLaugh(Hyena panda, Predicate<Hyena> joke) {
            var r = joke.test(panda) ? "hahaha" : "silence";
            System.out.print(r);
        }
    }

    public static void main(String[] args) {

        // Q1
        Panda p1 = new Panda();
        p1.age = 1;
        check(p1, p -> p.age < 5);

        // Q10
        Review_Questions rq = new Review_Questions();
        rq.remove(List.of('a', 'b', '1'));

        // Q12
        Function<Integer, Integer> s = a -> a + 4;
        Function<Integer, Integer> t = a -> a * 3;
        Function<Integer, Integer> c = s.compose(t);
        System.out.println(c.apply(1));

        // Q13
        int length = 3;

        for (int i = 0; i < 3; i++) {
            if (i % 2 == 0) {
                Supplier<Integer> supplier = () -> length; // A
                System.out.println(supplier.get());        // B
            } else {
                int j = i;
                Supplier<Integer> supplier = () -> j;      // C
                System.out.println(supplier.get());        // D
            }
        }

        // Q15
        var p = new Hyena();
        double height = 10;
        int age = 1;
        testLaugh(p, var -> p.age <= 10);
        // testLaugh(p, h -> h.age < 5);
        age = 2;
        System.out.println();

        // Q19
        Set<?> set = Set.of("lion", "tiger", "bear");
        var copy = Set.copyOf(set);
        Consumer<Object> consumer = System.out::println;
        copy.forEach(consumer);


    }
}
