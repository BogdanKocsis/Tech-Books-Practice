package Chapter_5_Methods;

//tow of the parts - the method name and parameter list - are called the method signature.
//access modifiers -> private, public, protected and package access.


/**
 * optional specifiers
 * <p>
 * static -> shared class object
 * abstract -> used in an abstract class
 * final -> not be overridden in a subclass
 * default -> used i na interface to provide a default implementation
 * synchronized -> used with multithread code
 * native -> used when interacting with code written in another language, such c++
 * strictfp -> used for making floating-point calculations portable
 **/


public class Methods {
    int hunger = 4;

    /* return type other than void are required to have a return. This return statement
 must include the primitive or object to be returned.*/

    int getHeight1() {
        int temp = 9;
        return temp;
    }

    void nap() {
    }

    //parameter List and method signature
    public void visitZoo(String name, int waitTime) {

    }

    public void oneException() throws IllegalArgumentException {

    }

    //declaring local and instance variables
    public int feedZooAnimals() {
        int snack = 10;

        if (snack > 4) {
            long dinner = snack++;
            hunger--;
        }
        return snack;
    }

    public void zooAnimalCheckup(boolean isWeekend) {
        final int rest;

        if (isWeekend) rest = 5;
        else rest = 20;
        System.out.println(rest);
    }

    public static void main(String[] args) {
        Methods tests = new Methods();
        tests.zooAnimalCheckup(false);
        System.out.println(tests);

        run(11, 77);
        walkDog(1);
        walkDog(1, 2);
        walkDog(1, 2, 3);
        walkDog(1, new int[]{4, 5});

        int result = sum(1, 2, 3);
        System.out.println("Sum: " + result);

        printMessage("Hello", "World");
    }

    //The compiler does not apply a default value to final variables. must receive a value...

    /**
     * Varargs
     * A method can have at most one varargs parameter
     * if a method contains a varargs parameter, it must be the last parameter in the list.
     */

    public void walk1(int... steps) {

    }

    public void walk2(int start, int... steps) {

    }
    //public void walk3(int...steps, int start){} // DOES NOT COMPILE
    //public void walk4(int...start, int... steps){} // DOES NOT COMPILE

    //examples
    public static void walk11(int... steps) {
        int[] step2 = steps; //not necessarily, but shows steps is an array.
        System.out.println(step2.length);
    }

    //accessing elements of a varargs parameter
    public static void run(int... steps) {
        System.out.println(steps[1]);
    }

    //using varargs with other parameters
    public static void walkDog(int start, int... steps) {
        System.out.println(steps.length);
    }

    public static int sum(int... nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }

    public static void printMessage(String... messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    //Static initializersPassing
    private static final int NUM_SECONDS_PER_MINUTE;

    private static final int NUM_MINUTES_PER_HOUR;

    static {
        NUM_SECONDS_PER_MINUTE = 60;
        NUM_MINUTES_PER_HOUR = 60;
    }

    //methods final cannot be overridden.
    //methods private cannot be overridden.
}
