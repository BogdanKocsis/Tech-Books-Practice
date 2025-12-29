package Chapter_9_Collections_and_Generics;

/*
    E for an element
    K for a map key
    V for a map value
    N for a number
    T for a generic data type
    S, U, V, and so forth for multiple generic types

 */


import java.util.List;

public class Generics {

    // unbounded wildcard
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    // upper bounded wildcard
    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list)
            count += number.longValue();
        return count;
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        List<String> strList = List.of("one", "two", "three");

        printList(intList);
        printList(strList);

        List<Double> doubleList = List.of(1.5, 2.5, 3.5);
        System.out.println("Total: " + total(doubleList));
    }

}
