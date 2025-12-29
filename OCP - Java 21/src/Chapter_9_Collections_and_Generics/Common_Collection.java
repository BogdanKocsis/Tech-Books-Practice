package Chapter_9_Collections_and_Generics;

import java.util.*;

public class Common_Collection {

    public static void main(String[] args) {

        // add() method behavior in List and Set
        Collection<String> list = new ArrayList<>();
        System.out.println(list.add("Sparrow"));
        System.out.println(list.add("Sparrow"));

        Collection<String> set = new HashSet<>();
        System.out.println(set.add("Sparrow"));
        System.out.println(set.add("Sparrow")); //false

        // remove() method behavior in List and Set
        Collection<String> birds = new ArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        System.out.println(birds.remove("cardinal")); //false
        System.out.println(birds.remove("hawk")); //true
        System.out.println(birds);

        // counting elements
        Collection<String> birds2 = new ArrayList<>();
        System.out.println(birds2.isEmpty());
        System.out.println(birds2.size());
        birds2.add("hawk");
        birds2.add("hawk");
        System.out.println(birds2.isEmpty());
        System.out.println(birds2.size());

        // clearing a collection
        birds2.clear();
        System.out.println(birds2.isEmpty());
        System.out.println(birds2.size());

        // checking for an element
        Collection<String> birds3 = new ArrayList<>();
        birds3.add("hawk");
        System.out.println(birds3.contains("hawk")); //true
        System.out.println(birds3.contains("robin")); //false

        // removing with a condition
        Collection<String> anotherList = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(anotherList);
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(anotherList);

        // iterating over a collection
        Collection<String> cats = List.of("Annie", "Ripley");
        cats.forEach(System.out::println);

        // equality of collections
        var list1 = List.of(1, 2);
        var list2 = List.of(2, 1);
        var set1 = Set.of(1, 2);
        var set2 = Set.of(2, 1);

        System.out.println(list1.equals(list2)); //false
        System.out.println(set1.equals(set2)); //true
        System.out.println(list1.equals(set1)); //false

        // unboxing nulls
        var heights = new ArrayList<Integer>();
        heights.add(null);
        int h = heights.get(0); //NullPointerException

    }
}
