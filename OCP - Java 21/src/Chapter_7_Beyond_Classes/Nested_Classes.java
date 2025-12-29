package Chapter_7_Beyond_Classes;

public class Nested_Classes {
    private String greeting = "Hi";

    protected class Room { // inner class declaration
        public int repeat = 3;

        public void enter() {
            for (int i = 0; i < repeat; i++) {
                greet(greeting);
            }
        }

        private static void greet(String message) {
            System.out.println(message);
        }
    }

    public void enterRoom() {
        Room room = new Room();
        room.enter();
    }

    public class Park {
        static class Ride { // static nested class
            private int price = 6;
        }
    }

    public class PrintNumbers {
        private int length = 5;

        public void calculate() {
            final int width = 20;
            class Calculator { // local class
                public void multiply() {
                    System.out.println(length * width);
                }
            }
            Calculator calculator = new Calculator();
            calculator.multiply();
        }

    }

    public class ZooGiftshop {
        abstract class SaleTodayOnly {
            abstract int dollarsOff();
        }

        public int admission(int basePrice) {
            SaleTodayOnly sale = new SaleTodayOnly() { // anonymous inner class
                int dollarsOff() {
                    return 3;
                }
            };
            return basePrice - sale.dollarsOff();
        }
    }

    public static void main(String[] args) {
        Nested_Classes house = new Nested_Classes();
        Room room = house.new Room(); // creating instance of inner class
        room.enter(); // calling method of inner class

        var ride = new Park.Ride(); // creating instance of static nested class
        System.out.println("Ride Price: " + ride.price);

        PrintNumbers printNumbers = house.new PrintNumbers();
        printNumbers.calculate(); // prints 100

        ZooGiftshop shop = house.new ZooGiftshop();
        int finalPrice = shop.admission(20);
        System.out.println("Final Admission Price: " + finalPrice);
    }
}
