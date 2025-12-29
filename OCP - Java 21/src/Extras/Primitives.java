package Extras;

/**
 * Java Numeric Promotion Rules
 * <p>
 * If two values have different data types, Java will automatically promote one of the values to the larger of the two data types.
 * If one of the values is integral and the other is floating-point, Java will automatically promote the integral value to the floating-point value’s data type.
 * Smaller data types such as byte, short, and char, are first promoted to int any time they’re used with a Java binary arithmetic operator,
 * even if neither of the operands is int.
 * After all promotion has occurred and the operands have the same data type, the resulting value will have the same data type as its promoted operands
 */

public class Primitives {
    public static void main(Strings[] args) {
        boolean fun = false; //default value is false
        byte b = 8; //default value is 0
        int i = 32; //default value is 0
        long l = 64L; //L or l is required, default value is 0L
        double d = 123.45; //default value is 0.0
        float f = 12.3f; //f or F is required, default value is 0.0f
        char c = 'c'; //default value is '\u0000' (null character)
        char def_c;
        short s = 16; //default value is 0

        long lfi = i;
        System.out.println("Long from int: " + lfi);
        double dff = f;
        System.out.println("Double from float: " + dff);

        int formattedInt = 1_000_000; // _ cannot lead or be next to a decimal point
        System.out.println("Formatted int with underscores: " + formattedInt);

        float ffd = (float) d;
        System.out.println("Float from double with cast: " + ffd);

        byte bc = (byte) c;
        System.out.println("Byte from char with cast: " + bc);

        bc = (byte) 100_000_000;
        System.out.println("Byte from large int with cast (overflow): " + bc);

        int iff = (int) f;
        System.out.println("Int from float with cast: " + iff); // .3 is truncated

        int bsum = b * 2;
        System.out.println("Byte multiplied by int promoted to int: " + bsum);

        float fdiv = i / f;
        System.out.println("Int divided by float promoted to float: " + fdiv);

        int div = i / 8;
        System.out.println("Int divided by int remains int: " + div);

        System.out.println("Increment c to " + (++c)); //d

        double dd = l; // long to double
        System.out.println("Double from long: " + dd);

        int bmod = 3 % 10;
        System.out.println("3 mod 10: " + bmod);
    }
}
