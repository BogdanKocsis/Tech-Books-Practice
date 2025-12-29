package Chapter_9_Collections_and_Generics;

import java.util.*;

public class Using_List_and_Set_Interface {
    public static void main(String[] args) {

        String[] array = {"A", "B", "C"};
        List<String> asList = Arrays.asList(array); // [A, B, C]
        List<String> of = List.of(array); // [A, B, C]
        List<String> copy = List.copyOf(asList); // [A, B, C]

        array[0] = "Z";
        System.out.println(asList); // [Z, B, C]
        System.out.println(of); // [A, B, C]
        System.out.println(copy); // [A, B, C]

        asList.set(0, "X");
        System.out.println(Arrays.toString(array));

        // list methods

        List<String> list = new ArrayList<>();
        list.add("SD");
        list.add(0, "NY");
        list.set(1, "FL");
        System.out.println(list.get(0));
        list.remove("NY");
        list.remove(0);
        // list.set(0, "?"); // IndexOutOfBoundsException

        var numbers = Arrays.asList(1, 2, 3);
        numbers.replaceAll(x -> x * 2);
        System.out.println(numbers); // [2, 4, 6]

        // removing from a list

        var linkedList = new LinkedList<Integer>();
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.remove(2);
        linkedList.remove(Integer.valueOf(2));
        System.out.println(linkedList); // [3]

        // searching in a list

        var anotherList = List.of("peacock", "chicken", "peacock", "turkey");
        System.out.println(anotherList.indexOf("peacock")); // 0
        System.out.println(anotherList.lastIndexOf("peacock")); // 2
        System.out.println(anotherList.indexOf("penguin")); // -1

        // converting to an array
        List<String> listOfString = new ArrayList<>();
        listOfString.add("hawk");
        listOfString.add("robin");
        Object[] objectArray = listOfString.toArray();
        String[] stringArray = listOfString.toArray(new String[0]);
        list.clear();
        System.out.println(objectArray.length);
        System.out.println(stringArray.length);

        // set methods

        Set<Integer> set = new HashSet<>();
        boolean b1 = set.add(66); // true
        boolean b2 = set.add(10); // true
        boolean b3 = set.add(66); // false
        boolean b4 = set.add(8); // true
        for (Integer value : set)
            System.out.print(value + ", ");
        System.out.println();

        // LinkedHashSet maintains insertion order

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(66);
        linkedHashSet.add(10);
        linkedHashSet.add(66);
        linkedHashSet.add(8);
        for (Integer value : linkedHashSet)
            System.out.print(value + ", ");
        System.out.println();

        // TreeSet sorts the elements

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(66);
        treeSet.add(10);
        treeSet.add(66);
        treeSet.add(8);
        for (Integer value : treeSet)
            System.out.print(value + ", ");
        System.out.println();


    }
}
