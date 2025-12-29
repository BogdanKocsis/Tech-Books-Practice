package Chapter_2_Operators;

public class Operator_Precedence {

    //java supports three flavors of operators: unary, binary and ternary.

    public static void main(String[] args) {
        int cookies = 4;
        double reward = 3 + 2 * --cookies;
        System.out.print("Zoo animal receives: " + reward + " reward points");

        // the multiplication operator (*) has a higher precedent.
        // the assignment operator (=) has the lowest order of precedent.

        boolean isAnimalAsleep = false;
        System.out.print(isAnimalAsleep);  // false
        isAnimalAsleep = !isAnimalAsleep;
        System.out.print(isAnimalAsleep);  // true

        int number = 70;
        int negated = ~number;
        System.out.println(negated);   // -71
        System.out.println(~negated);  // 70

        double zooTemperature = 1.21;
        System.out.println(zooTemperature);  // 1.21
        zooTemperature = -zooTemperature;
        System.out.println(zooTemperature);  // -1.21
        zooTemperature = -(-zooTemperature);
        System.out.println(zooTemperature);  // -1.21

//        int pelican = !5;         // DOES NOT COMPILE
//        boolean penguin = -true;  // DOES NOT COMPILE
//        boolean parrot = ~true;   // DOES NOT COMPILE
//        boolean peacock = !0;     // DOES NOT COMPILE

        int parkAttendance = 0;
        System.out.println(parkAttendance);    // 0
        System.out.println(++parkAttendance);  // 1
        System.out.println(parkAttendance);    // 1
        System.out.println(parkAttendance--);  // 1
        System.out.println(parkAttendance);    // 0

//        long pigeon = 1 + ((3 * 5) / 3;       // DOES NOT COMPILE
//        int blueJay = (9 + 2) + 3) / (2 * 4;  // DOES NOT COMPILE
//        short robin = 3 + [(4 * 2) + 4];      // DOES NOT COMPILE

        System.out.println(9 / 3);   // 3
        System.out.println(9 % 3);   // 0

        System.out.println(10 / 3);  // 3
        System.out.println(10 % 3);  // 1

        System.out.println(11 / 3);  // 3 -> floor value
        // it just means the value without anything after the decimal point.
        // For example, the floor value is 4 for each of the values 4.0, 4.5, and 4.9999999
        System.out.println(11 % 3);  // 2

        System.out.println(12 / 3);  // 4
        System.out.println(12 % 3);  // 0

//        short x = 10;
//        short y = 3;
//        var z = x * y; // int

//        short w = 14; //promoted to int
//        float x = 13; //w promoted to float to be multiplied with x
//        double y = 30; // w promoted to double to be divided by y
//        var z = w * x / y; //result is double

        //Casting
        int fur = (int) 5;
        int hair = (short) 2;
        String type = (String) "Bird";
        short tail = (short) (4 + 10);
//      long feathers = 10(long);  // DOES NOT COMPILE
//      float egg = 2.0 / 9;        // DOES NOT COMPILE
//      int tadpole = (int)5 * 2L;  // DOES NOT COMPILE
//      short frog = 3 - 2.0;       // DOES NOT COMPILE
//
//      System.out.print(2147483647 + 1);  // -2147483648 (Overflow)

//       short mouse = 10;
//       short hamster = 3;
//       short capybara = mouse * hamster;  // DOES NOT COMPILE
//       Java thinks we are trying to implicitly convert from a larger type (int) to a smaller type (short).

        short mouse = 10;
        short hamster = 3;
        short capybara = (short) (mouse * hamster);  // Explicit casting
        System.out.print(capybara);  // 30

        // Return Value of an Assignment
        long wolf = 5;
        long coyote = (wolf = 3);
        System.out.println(wolf);   // 3
        System.out.println(coyote); // 3

    }
}
