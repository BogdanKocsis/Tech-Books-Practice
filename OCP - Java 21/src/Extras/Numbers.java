package Extras;

public class Numbers {
    public static void main(Strings[] args) {
        int bii = 0b000011; // 1 * 2^0 + 1 * 2^1 = 3
        int hex = 0x00AFA23; // 3 * 16^0 + 2 * 16^1 + 10 * 16^2 + 15 * 16^3 = 1143619
        int oct = 0021475; // 5 * 8^0 + 7 * 8^1 + 4 * 8^2 + 1 * 8^3 + 2 * 8^4 = 1149

        System.out.println("Binary 0b000011: " + bii);
        System.out.println("Hexadecimal 0x00AFA23: " + hex);
        System.out.println("Octal 0021475: " + oct);

        int bshift = bii << 1; // left shift by 1 (multiply by 2)
        System.out.println("Left shift bii by 1: " + bshift); // 2^0 + 2^1 + 2^2 = 6 eg. 0b000110
        bshift >>= 2;
        System.out.println("Right shift bshift by 2: " + bshift); // 2^1 = 2 eg. 0b000010
        System.out.println("|         " + (0b0000001 | 0b0000011)); // or results in 3 and would be 1
        System.out.println("Flip bits 1 is " + (~1)); // flip bits of 1 results in -2

        int neg = -64;
        System.out.println("-64 >> 2 is " + (neg >> 1)); // remains negative
        System.out.println("-64 >>> 2 is " + (neg >>> 1)); // unsigned shift becomes large positive
        System.out.println("-88 >>> " + (neg >>> -88)); // negative shift becomes mod 32



    }
}
