package Chapter_4_Core_APIs;

/**
 * StringBuilder class creates or manipulate a String without storing interim String values.
 * Is not immutable.
 * You can inserting Data, Deleting Contents, Replacing Portions, Reversing and others.
 * the append() method is by far the most frequently used method in stringBuilder
 * <p>
 * Stores characters specified by its capacity, if it is exceeded, it is increased to accommodate the additional characters;
 * You don't need to allocate new objects when you perform a concatenation;
 * They are not synchronized;
 * They are not thread safe;
 */

public class StringBuilder_Example {
    public static void main(String[] args) {
        /** EXEMPLE
         *  WITHOUT STRINGBUILDER...
         */

        String alpla = "";
        for (char current = 'a'; current <= 'z'; current++) {
            alpla = alpla + current;
        }

        System.out.println(alpla);
        System.out.println("----------------------------------------------");


        StringBuilder alphaa = new StringBuilder();

        for (char current = 'a'; current <= 'z'; current++) {
            alphaa.append(current);
        }

        System.out.println(alphaa);
        System.out.println("----------------------------------------------");

        /** EASY EXEMPLE
         *  WITH STRINGBUILDER...
         */

        StringBuilder a = new StringBuilder("abc");

        StringBuilder b = a.append("de");

        b = b.append("f").append("g");

        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}
