package Extras;


/**
 * Operator Precedence
 * () (first) ++ -- + - ~ ! (unary) * / % (multiply) + - (additive) << >> >>> & ^ |
 */
public class Operators {
    public static void main(String[] args) {
        int i = 10;
        int x = i++;
        int y = i % 3;

        System.out.println(x);
        System.out.println(y); // y is assigned 2 after i incremented
    }
}
