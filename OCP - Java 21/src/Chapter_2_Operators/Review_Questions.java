package Chapter_2_Operators;

public class Review_Questions {

    public static void main(String[] args) {
        // Q4

        boolean canine = true, wolf = true;
        int teeth = 20;
        canine = (teeth != 10) ^ (wolf = false);
        System.out.println(canine + ", " + teeth + ", " + wolf);

        // Q7

        int ph = 7, vis = 2;
        boolean clear = vis > 1 & (vis < 9 || ph < 2);
        boolean safe = (vis > 2) && (ph++ > 1);
        boolean tasty = 7 <= --ph;
        System.out.println(clear + "-" + safe + "-" + tasty);

        // Q8

        int pig = (short) 4;
        pig = pig++;
        long goat = (int) 2;
        goat -= 1.0;
        System.out.println(pig + " - " + goat);

        // Q9

        int a = 2, b = 4, c = 2;
        System.out.println(a > 2 ? --c : b++); // b=4
        System.out.println(b = (a != c ? a : b++)); // b=5
        System.out.println(a > b ? b < c ? b : 2 : 1); // 1

        /*
        Q10

        short height = 1, weight = 3;
        short zebra = (byte) weight * (byte) height;
        double ox = 1 + height * 2 + weight;
        long giraffe = 1 + 9 % height + 1;
        System.out.println(zebra);
        System.out.println(ox);
        System.out.println(giraffe);

         */

        // Q11

        int sample1 = (2 * 4) % 3;
        int sample2 = 3 * 2 % -3;
        int sample3 = 5 * (1 % 2);
        System.out.println(sample1 + ", " + sample2 + ", " + sample3);

        // Q13

        boolean sunny = true, raining = false, sunday = true;
        boolean goingToTheStore = sunny & raining ^ sunday; // false ^ sunday, which is true
        boolean goingToTheZoo = sunday && !raining;
        boolean stayingHome = !(goingToTheStore && goingToTheZoo);
        System.out.println(goingToTheStore + "-" + goingToTheZoo
                + "-" +stayingHome);

        // Q17

        int ticketsTaken = 1;
        int ticketsSold = 3;
        ticketsSold += 1 + ticketsTaken++;
        ticketsTaken *= 2;
        ticketsSold += (long)1;
        System.out.println(ticketsTaken + ", " + ticketsSold);

        // Q19
        int start = 7;
        int end = 4;
        end += ++start;
        start = (byte)(Byte.MAX_VALUE + 1);
        System.out.println(start + ", " + end);

    }

        /*
        Q6

        public static class CandyCounter {
        static long addCandy(double fruit, float vegetables) {
            return (int) fruit + vegetables;
        }

    public static maine(String[] args) {
        System.out.print(addCandy(1.4, 2.4f) + ", ");
        System.out.print(addCandy(1.9, (float) 4) + ", ");
        System.out.print(addCandy((long) (int) (short) 2, (float) 4));

     }

         */

}
