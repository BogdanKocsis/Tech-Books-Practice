package Chapter_8_Lambdas_and_Functional_Interfaces;

import java.util.ArrayList;
import java.util.List;

public class LambdasAndOthers {
    public record Animal(String species, boolean canHop, boolean canSwim) {
    }

    public interface CheckTrait {
        boolean test(Animal a);
    }

    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal a : animals) {
            if (checker.test(a)) {
                System.out.println(a + " ");
            }
        }
    }

    // Functional Interface
    @FunctionalInterface
    public interface Sprint {
        public void sprint(int speed);
    }

    public static class Tiger implements Sprint {
        public void sprint(int speed) {
            System.out.println("Animal is sprinting fast! " + speed);
        }
    }


    public static void main(String[] args) {
        var animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));
        print(animals, Animal::canHop);

        Tiger tiger = new Tiger();
        tiger.sprint(100);

    }
}

