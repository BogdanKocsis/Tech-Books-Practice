package Chapter_7_Beyond_Classes;

public class Polymorphism {

    public class Primate {
        public boolean hasHair() {
            return true;
        }
    }

    public interface HasTail {
        public abstract boolean isTailStriped();
    }

    public class Lemur extends Primate implements HasTail {
        public boolean isTailStriped() {
            return false;
        }

        public int age = 10;
    }

    public static void main(String[] args) {
        Polymorphism obj = new Polymorphism();

        Lemur lemur = obj.new Lemur();
        System.out.println("Lemur Age: " + lemur.age);

        HasTail hasTail = lemur;
        System.out.println("Is Tail Striped: " + hasTail.isTailStriped());

        Primate primate = lemur;
        System.out.println("Has Hair: " + primate.hasHair());


        Primate anotherPrimate = obj.new Lemur(); // Upcasting
        HasTail anoterHasTail = obj.new Lemur(); // Upcasting

        System.out.println("Has Hair: " + anotherPrimate.hasHair());
        System.out.println("Is Tail Striped: " + anoterHasTail.isTailStriped());

        // Downcasting
        Lemur anotherLemur = (Lemur) primate;
        System.out.println("Lemur Age: " + anotherLemur.age);

    }
}
