package Chapter_9_Collections_and_Generics;

import java.util.*;

public class Reviewing_Collection_Types {
    public static void main(String[] args) {

        // using unmodifiable wrappers
        Collection<String> coll = Collections.unmodifiableCollection(List.of("brown"));
        List<String> list = Collections.unmodifiableList(List.of("orange"));
        Set<String> set = Collections.unmodifiableSet(Set.of("green"));
        Map<String, Integer> map = Collections.unmodifiableMap(Map.of("red", 1));

        Map<String, Integer> m = new TreeMap<>();
        m.put("blue", 41);
        m.put("red", 90);
        List<String> l = Arrays.asList("green", "yellow");
        Set<String> s = new HashSet<>(list);

        Map<String, Integer> mapView = Collections.unmodifiableMap(m);
        Collection<String> collView = Collections.unmodifiableCollection(l);
        List<String> listView = Collections.unmodifiableList(l);
        Set<String> setView = Collections.unmodifiableSet(s);

//        collView.add("pink");  // java.lang.UnsupportedOperationException
//        listView.add("purple"); // java.lang.UnsupportedOperationException
//        setView.add("cyan");    // java.lang.UnsupportedOperationException
//        mapView.put("black", 0); // java.lang.UnsupportedOperationException

        System.out.println(mapView);
        System.out.println(collView);
        System.out.println(listView);
        System.out.println(setView);

        m.put("blue", 105);
        l.set(1, "purple");

        System.out.println(mapView);
        System.out.println(collView);
        System.out.println(listView);
        System.out.println(setView);
    }
}
