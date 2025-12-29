package Chapter_9_Collections_and_Generics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class Map_Interface {

    static void addElementsAndPrint(Map<String, String> map) {
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaves");
        String food = map.get("koala");
        for (String key : map.keySet()) {
            System.out.print(key + ", ");
        }
        System.out.println();

        System.out.println(map.containsKey("lion"));
        System.out.println(map.containsValue("lion"));
        System.out.println(map.size());
        map.clear();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("-------------------");

    }

    public static void main(String[] args) {

        addElementsAndPrint(new HashMap<>());
        addElementsAndPrint(new LinkedHashMap<>());
        addElementsAndPrint(new TreeMap<>());

        // iterating over map entries
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'A');
        map.put(2, 'B');
        map.put(3, 'C');
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
        map.values().forEach(System.out::println);

        // getting values safely
        Map<Character, String> map2 = new HashMap<>();
        map2.put('x', "spot");
        System.out.println("X marks the " + map2.get('x'));
        System.out.println("X marks the " + map2.getOrDefault('x', ""));
        System.out.println("Y marks the " + map2.get('y'));
        System.out.println("Y marks the " + map2.getOrDefault('y', "unknown"));

        // replacing values
        Map<Integer, Integer> map3 = new HashMap<>();
        map3.put(1, 2);
        map3.put(2, 4);
        Integer original = map3.replace(2, 10);
        System.out.println(map3);
        map3.replaceAll((k, v) -> k + v);
        System.out.println(map3);

        // putting values if absent
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);
        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        System.out.println(favorites);

        // merging values
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> map4 = new HashMap<>();
        map4.put("Jenny", "Bus Tour");
        map4.put("Tom", "Tram");
        map4.put("Sam", null);

        String jenny = map4.merge("Jenny", "Skyride", mapper);
        String tom = map4.merge("Tom", "Skyride", mapper);
        String sam = map4.merge("Sam", "Skyride", mapper);

        System.out.println(map4);
        System.out.println(jenny);
        System.out.println(tom);
        System.out.println(sam);
    }
}
