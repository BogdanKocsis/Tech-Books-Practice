package Chapter_9_Collections_and_Generics;

import java.util.*;

public class Sequenced_Collection {
    // A simple interface representing a sequenced collection
    public static void welcomeNext(SequencedCollection<String> visitors) {
        System.out.println("Welcome to the Zoo! " + visitors.getFirst());
        visitors.removeFirst();
    }

    public static void moveToEnd(SequencedCollection<String> visitors) {
        visitors.addLast(visitors.removeFirst());
    }


    // A simple interface representing a sequenced map
    public static void welcomeNext(SequencedMap<String, String> visitors) {
        System.out.println("Welcome to the Zoo! " + visitors.pollFirstEntry());
    }

    public static void main(String[] args) {
        var visitArrayList = new ArrayList<String>(List.of("Huey", "Dewey", "Louie"));
        var visitLinkedList = new LinkedList<String>(List.of("Moe", "Larry", "Shemp"));
        var visitTreeSet = new TreeSet<String>(Set.of("Alvin", "Simon", "Theodore"));

//        welcomeNext(visitArrayList);  // Welcome to the Zoo! Huey
//        welcomeNext(visitLinkedList); // Welcome to the Zoo! Moe
//        welcomeNext(visitTreeSet);    // Welcome to the Zoo! Alvin


        moveToEnd(visitArrayList);
        welcomeNext(visitArrayList);  // Welcome to the Zoo! Bingo

        moveToEnd(visitLinkedList);
        welcomeNext(visitLinkedList); // Welcome to the Zoo! Odie

        //moveToEnd(visitTreeSet);      // java.lang.UnsupportedOperationException
        welcomeNext(visitTreeSet);

        var visitTreeMap = new TreeMap<String,String>(
                Map.of("Pink", "Blossom", "Green", "Buttercup", "Blue", "Bubbles"));
        welcomeNext(visitTreeMap);

    }

}
