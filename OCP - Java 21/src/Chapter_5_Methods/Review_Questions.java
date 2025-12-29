package Chapter_5_Methods;

import static Chapter_5_Methods.Review_Questions.Rope.*;

public class Review_Questions {

    // Rope.java
    public static class Rope {
        public static int LENGTH = 5;

        static {
            LENGTH = 10;
        }

        public static void swing() {
            System.out.print("swing ");
        }
    }

    public static class Rope_Two {
        public static void swing() {
            System.out.print("swing");
        }

        public void climb() {
            System.out.println("climb");
        }

        public static void play() {
            swing();
        }
    }

    public static class Rope_Three {
        public static int length = 0;
    }

    public static Rope_Three rope3 = new Rope_Three();
    public static Rope_Three rope4 = new Rope_Three();

    {
        System.out.println(rope3.length);
    }

    public void print(byte x) {
        System.out.print("byte-");
    }

    public void print(int x) {
        System.out.print("int-");
    }

    public void print(float x) {
        System.out.print("float-");
    }

    public void print(Object x) {
        System.out.print("Object-");
    }

    public static long square(int x) {
        var y = x * (long) x;
        x = -1;
        return y;
    }

    public static StringBuilder work(StringBuilder a,
                                     StringBuilder b) {
        a = new StringBuilder("a");
        b.append("b");
        return a;
    }

    static void execute() {
        System.out.print("1-");
    }

    /*
    static void execute(int num) {
        System.out.print("2-");
    }
     */

    static void execute(Integer num) {
        System.out.print("3-");
    }

    static void execute(Object num) {
        System.out.print("4-");
    }

    static void execute(int[] nums) {
        System.out.print("5-");
    }


    public static void main(String[] args) {
        // Q10

        Rope.swing();
        new Rope().swing();
        System.out.println(LENGTH);

        // Q11

        Rope_Two rope = new Rope_Two();
        rope.play();
        Rope_Two rope2 = null;
        System.out.print("-");
        rope2.play();
        System.out.println();

        // Q13

        rope3.length = 2;
        rope4.length = 8;
        System.out.println(rope3.length);

        // Q16

        Review_Questions reviewQuestions = new Review_Questions();
        short s = 123;
        reviewQuestions.print(s);
        reviewQuestions.print(true);
        reviewQuestions.print(6.789);
        System.out.println();

        // Q17
        var value = 9;
        var result = square(value);
        System.out.println(value);

        // Q18

        var s1 = new StringBuilder("s1");
        var s2 = new StringBuilder("s2");
        var s3 = work(s1, s2);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);

        // Q20

        Review_Questions.execute(100);
        Review_Questions.execute(100L);

    }
}
