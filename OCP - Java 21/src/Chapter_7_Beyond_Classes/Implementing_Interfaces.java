package Chapter_7_Beyond_Classes;

public class Implementing_Interfaces {

    // Extending multiple interfaces
    public interface Nocturnal {
        public int hunt();
    }

    public interface CanFly {
        public void flap();
    }

    public interface HasBigEyes extends Nocturnal, CanFly {
    }

    public class Owl implements HasBigEyes {
        public int hunt() {
            return 5;
        }

        public void flap() {
            System.out.println("Flap!");
        }
    }

    // Inheriting duplicate abstract methods
    public interface Herbivore {
        public int eatPlants(int plantsLeft);
    }

    public interface Omnivore {
        public int eatPlants(int plantsLeft);
    }

    public class Bear implements Herbivore, Omnivore {
        public int eatPlants(int plantsLeft) {
            System.out.println("Eating plants");
            return plantsLeft - 1;
        }
    }

    // A default interface method
    public interface IsColdBlooded {
        boolean hasScales();

        default double getTemperature() {
            return 10.0;
        }
    }

    public class Snake implements IsColdBlooded {
        public boolean hasScales() { // Required override
            return true;
        }

        public double getTemperature() { // Optional override
            return 12.2;
        }
    }

    // Declaring static Interface Methods

    public interface Hop {
        static int getJumpHeight() {
            return 8;
        }
    }

    public class Skip implements Hop {
        public int skip() {
            return Hop.getJumpHeight();
        }
    }

    public class Bunny implements Hop {
        public void printDetails() {
            System.out.println("Jump height: " + Hop.getJumpHeight());
        }
    }

    public static void main(String[] args) {
        Implementing_Interfaces impl = new Implementing_Interfaces();
        Owl owl = impl.new Owl();
        owl.flap();
        System.out.println("Hunt score: " + owl.hunt());

        Bear bear = impl.new Bear();
        int plantsLeft = 10;
        plantsLeft = bear.eatPlants(plantsLeft);
        System.out.println("Plants left after eating: " + plantsLeft);

        Snake snake = impl.new Snake();
        System.out.println("Snake has scales: " + snake.hasScales());
        System.out.println("Snake temperature: " + snake.getTemperature());

        Skip skip = impl.new Skip();
        System.out.println("Skip jump height: " + skip.skip());
    }
}
