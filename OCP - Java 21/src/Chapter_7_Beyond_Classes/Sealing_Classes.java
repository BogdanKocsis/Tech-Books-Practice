package Chapter_7_Beyond_Classes;

public class Sealing_Classes {

    // Every class that directly extends a sealed class must specify exactly one of the following three modifiers: final, sealed, or non-sealed.
    public sealed class Antelope permits Gazelle {
    }

    public final class Gazelle extends Antelope {
    }
    /* public class DamaGazelle extends Gazelle{} */ // DOES NOT COMPILE

    // sealed subclasses
    public sealed class Fish permits ClownFish{}
    public sealed class ClownFish extends Fish permits OrangeClownFish{}
    public final class OrangeClownFish extends ClownFish{}

    // non-sealed subclass
    abstract sealed class Mammal permits Feline{}
    non-sealed class Feline extends Mammal{}
    class Tiger extends Feline{}

    // sealed interface
    public sealed interface Swims permits Duck, Swan, Floats {}
    public static final class Duck implements Swims {}
    public static final class Swan implements Swims {}
    public non-sealed static class Floats implements Swims {}

    public String getType(Swims swims){
        return switch (swims) {
            case Duck d -> "Duck";
            case Swan s -> "Swan";
            case Floats f -> "Floats";
        };
    }

    public static void main(String[] args) {

        Sealing_Classes sc = new Sealing_Classes();
        Swims s1 = new Duck();
        Swims s2 = new Swan();
        Swims s3 = new Floats();

        System.out.println(sc.getType(s1)); // Duck
        System.out.println(sc.getType(s2)); // Swan
        System.out.println(sc.getType(s3)); // Floats
    }
}
