package Chapter_3_Making_Decisions;

public class Loops {
    int roomInBelly = 5;

    void eatCheese(int bitesOfCheese) {
        while (bitesOfCheese > 0 && roomInBelly > 0) {
            bitesOfCheese--;
            roomInBelly--;
        }
        System.out.println(bitesOfCheese + " pieces of cheese left");
    }

    void printNames(String[] names) {
        for (String name : names)
            System.out.println(name);
    }

    public static void main(String[] args) {
        var obj = new Loops();

        // While Loop
        obj.eatCheese(10); // prints 5

        // Do-While Loop

        int lizard = 0;
        do {
            lizard++;
        } while (false);
        System.out.println(lizard);

        // For Loop

        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (var counter = 4; counter >= 0; counter--) {
            System.out.print(counter + " ");
        }
        System.out.println();

        int x = 0;
        for (long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
            System.out.print(y + " ");
        }
        System.out.println(x + " ");

        // For-Each Loop
        String[] names = {"Tom", "Bogdan", "Kamil" };
        obj.printNames(names);
    }
}
