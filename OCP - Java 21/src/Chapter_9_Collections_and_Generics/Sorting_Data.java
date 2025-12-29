package Chapter_9_Collections_and_Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ========================================================================================
 * Comparison of Comparable and Comparator
 * ========================================================================================
 * | Difference                                 | Comparable         | Comparator         |
 * |--------------------------------------------|--------------------|--------------------|
 * | Package name                               | java.lang          | java.util          |
 * | Interface must be implemented by class?    | Yes                | No                 |
 * | Method name in interface                   | compareTo()        | compare()          |
 * | Number of parameters                       | 1                  | 2                  |
 * | Common to declare using a lambda           | No                 | Yes                |
 * ========================================================================================
 */


public class Sorting_Data {

    // creating a comparable class
    public record Duck(String name) implements Comparable<Duck> {
        public int compareTo(Duck d) {
            return name.compareTo(d.name);
        }
    }

    // designing a comparator class
    public record ZooDuck(int id, String name) implements Comparable<ZooDuck> {
        public int compareTo(ZooDuck d) {
            return id - d.id; // sort by id
        }
    }

    // keeping compareTo and equals consistent
    public class Product implements Comparable<Product> {
        private int id;
        private String name;

        public int hashCode() {
            return id;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Product other)
                return this.id == other.id;
            return false;
        }

        public int compareTo(Product obj) {
            return this.name.compareTo(obj.name);
        }
    }

    // comparing data with a comparator
    public record Ducking(String name, int weight) implements Comparable<Ducking> {
        public int compareTo(Ducking d) {
            return name.compareTo(d.name);
        }

        public String toString() {
            return name;
        }
    }

    // comparing multiple fields
    public record Squirrel(int weight, String species) {
    }

    public static class MultiFieldComparator implements Comparator<Squirrel> {
        public int compare(Squirrel s1, Squirrel s2) {
            int result = s1.species().compareTo(s2.species());
            return result != 0 ? result : s1.weight() - s2.weight();
        }
    }

    public static void main(String[] args) {

        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"));
        Collections.sort(ducks);
        System.out.println(ducks);

        var d1 = new ZooDuck(5, "Daffy");
        var d2 = new ZooDuck(7, "Donald");
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.compareTo(d1));
        System.out.println(d2.compareTo(d1));


        Comparator<Ducking> byWeight = new Comparator<>() { // anonymous class
            public int compare(Ducking d1, Ducking d2) {
                return d1.weight - d2.weight;
            }
        };
        // Comparator<Ducking> byWeightLambda = (d1, d2) -> d1.weight - d2.weight; // lambda expression
        var duckies = new ArrayList<Ducking>();
        duckies.add(new Ducking("Quack", 7));
        duckies.add(new Ducking("Puddles", 10));
        Collections.sort(duckies); // sort by name
        System.out.println(duckies);
        Collections.sort(duckies, byWeight); // sort by weight
        System.out.println(duckies);

        var squirrels = new ArrayList<Squirrel>();
        squirrels.add(new Squirrel(15, "Gray"));
        squirrels.add(new Squirrel(10, "Red"));
        squirrels.add(new Squirrel(12, "Gray"));
        Collections.sort(squirrels, new MultiFieldComparator());
        System.out.println(squirrels);

        // Alternative using lambda
        Comparator<Squirrel> c = Comparator.comparing(Squirrel::species).thenComparing(Squirrel::weight).reversed();
        Collections.sort(squirrels, c);
        System.out.println(squirrels);

        // Sorting a list
        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        System.out.println(bunnies);
        bunnies.sort((b1, b2) -> b1.compareTo(b2));
        // bunnies.sort(String::compareTo); // Method reference alternative
        System.out.println(bunnies);
    }
}
