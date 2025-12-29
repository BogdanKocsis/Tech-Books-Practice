package Chapter_9_Collections_and_Generics;

import java.io.FileNotFoundException;
import java.util.*;

public class Reviews_Questions {

    public record Hello<T>(T t) {
        public Hello(T t) {
            this.t = t;
        }

        private <T> void println(T message) {
            System.out.print(t + "-" + message);
        }

        public static record Platypus(String name, int beakLength) {
            @Override
            public String toString() {
                return "" + beakLength;
            }
        }

        public static class MyComparator implements Comparator<String> {
            public int compare(String a, String b) {
                return b.toLowerCase().compareTo(a.toLowerCase());
            }
        }

        public static class Helper {
            public static <U extends Exception>
            void printException(U u) {

                System.out.println(u.getMessage());
            }
        }

        public static class Wildcard {
            public void showSize(List<?> list) {
                System.out.println(list.size());
            }
        }

        public record Sorted(int num, String text)
                implements Comparable<Sorted>, Comparator<Sorted> {

            public String toString() {
                return "" + num;
            }

            public int compareTo(Sorted s) {
                return text.compareTo(s.text);
            }

            public int compare(Sorted s1, Sorted s2) {
                return s1.num - s2.num;
            }
        }

        public static void main(String[] args) {
            // Q3
            var greetings = new ArrayDeque<String>();
            greetings.offerLast("hello");
            greetings.offerLast("hi");
            greetings.offerFirst("ola");
            greetings.pop();
            greetings.peek();
            while (greetings.peek() != null)
                System.out.print(greetings.pop());
            System.out.println();

            // Q5
            new Hello<String>("hi").println(1);
            new Hello("hola").println(true);
            System.out.println();

            // Q6
            Platypus p1 = new Platypus("Paula", 3);
            Platypus p2 = new Platypus("Peter", 5);
            Platypus p3 = new Platypus("Peter", 7);
            List<Platypus> list = Arrays.asList(p1, p2, p3);
            Collections.sort(list, Comparator.comparing(Platypus::beakLength).reversed());
//            Collections.sort(list, Comparator.comparing(Platypus::name)
//                    .thenComparingInt(Platypus::beakLength)
//                    .reversed());
            System.out.println(list);

            // Q8
            SequencedCollection<String> animals = new LinkedList<>();
            animals.addFirst("lions");
            animals.addLast("tigers");
            for (var a : animals)
                System.out.println(a);
            System.out.println(animals.getFirst());

            // Q9
            String[] values = {"123", "Abb", "aab"};
            Arrays.sort(values, new MyComparator());
            for (var s : values)
                System.out.print(s + " ");

            // Q10
            Helper.printException(new FileNotFoundException("A"));
            Helper.printException(new Exception("B"));

            // Q11
            var anotherList = List.of(1, 2, 3);
            var set = Set.of(1, 2, 3);
            var map = Map.of(1, 2, 3, 4);

            anotherList.forEach(System.out::println);
            set.forEach(System.out::println);
            map.keySet().forEach(System.out::println);
            map.values().forEach(System.out::println);

            // Q12
            Wildcard card = new Wildcard();
            ArrayList<? super Date> l = new ArrayList<Date>();
            ArrayList<? extends Number> l2 = new ArrayList<Integer>();
            card.showSize(l2);

            // Q13
            var s1 = new Sorted(88, "a");
            var s2 = new Sorted(55, "b");
            SequencedSet<Sorted> t1 = new TreeSet<Sorted>();
            t1.add(s1);
            t1.add(s2);
            var t2 = new TreeSet<Sorted>(s1);
            t2.add(s1);
            t2.add(s2);
            System.out.println(t1 + " " + t2);

            // Q14
            Comparator<Integer> c1 = (o1, o2) -> o2 - o1; // reverse order
            Comparator<Integer> c2 = Comparator.naturalOrder(); // natural order
            Comparator<Integer> c3 = Comparator.reverseOrder(); // reverse order

            var arrayList = Arrays.asList(5, 4, 7, 2);
            Collections.sort(arrayList, c2);
            Collections.reverse(list);
            Collections.reverse(list);
            System.out.println(Collections.binarySearch(arrayList, 2));

            // Q16
            var q = new LinkedList<>();
            //  List<Integer> q = new LinkedList<>();
            var u = Collections.unmodifiableCollection(q);
            q.add(10);
            q.add(12);
            q.remove(1);
            System.out.println(u);


            // Q20
            var numbersMap = new HashMap<Integer, Integer>();
            numbersMap.put(1, 10);
            numbersMap.put(2, 20);
            numbersMap.put(3, null);
            numbersMap.merge(1, 3, (a,b) -> a + b);
            numbersMap.merge(3, 3, (a,b) -> a + b);
            System.out.println(numbersMap);

            // Q22
            SequencedMap<Integer, String> cats = new TreeMap<>();
            cats.put(3, "Snowball");
            cats.put(2, "Sugar");
            cats.put(1, "Minnie Mouse");
            System.out.println(cats);
            cats.pollFirstEntry(); // removes and returns the first entry
            var id = cats.lastEntry().getKey(); // gets the last entry's key
            cats.pollFirstEntry();  // removes and returns the first entry
            System.out.print(cats.firstEntry().getValue());

        }
    }
}
