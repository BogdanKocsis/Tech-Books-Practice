package Chapter_7_Beyond_Classes;


public class Encapsulation {

    // Like enums, that means you can’t extend or inherit a record.
    public record Crane(int numberEggs, String name) {
        public Crane {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be null or blank");
            }
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }
    }

    // Pattern Matching for instanceof
    record Monkey(String name, int age) {
    }

    record Snake(Object data) {
    }

    static long showData(Snake snake) {
        return switch (snake) {
            case Snake(Long hiss) -> hiss + 1;
            case Snake(Integer nagina) -> nagina + 10;
            case Snake(Number crowley) -> crowley.intValue() + 100;
            case Snake(Object kaa) -> -1;
        };
    }

    public static void main(String[] args) {
        Encapsulation obj = new Encapsulation();
        Crane crane = new Crane(5, "sam");
        System.out.println("Crane Name: " + crane.name());
        System.out.println("Number of Eggs: " + crane.numberEggs());

        Object animal = new Monkey("George", 3);
        if (animal instanceof Monkey(String name, int age)) {
            System.out.println("Hello " + name);
            System.out.println("Your Age is: " + age);
        }

        System.out.println(showData(new Snake(1)));    // 11
        System.out.println(showData(new Snake(2L)));   // 3
        System.out.println(showData(new Snake(3.0))); // 103
    }
}
