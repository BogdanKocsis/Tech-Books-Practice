package Extras;

/*
 String escape characters:
  \t - tab.
  \b - backspace (a step backward in the text or deletion of a single character).
  \n - new line.
  \r - carriage return.
  \f - form feed.
  \' single quote.
  \" double quote.
  \\ backslash.
 */

import java.util.Arrays;

import static java.lang.IO.println;

public class Strings {
    static {
        System.out.println("Strings static initializer..");
    }

    public static void main(String[] args) {
        String s = "first"; //Strings are immutable
        String s1 = "first"; //Literals go to the string pool

        System.out.println(s == s1); //true, same reference from the pool
        System.out.println(s1.equals(s)); //true, same value

        var s2 = "second";

        String s3 = new String("first");
        String s4 = "fi" + "rst"; //added to string pool as "first"

        System.out.println(s1 == s3); //false, different references
        System.out.println(s1 == s4);
        ;
        System.out.println(s1.equals(s3)); //true, same value

        s3 = s3.intern();

        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3)); //true, same value

        System.out.println("hello world".substring(6));
        System.out.println("hello world".substring(0, 5));
        System.out.println("hello world".startsWith("hel"));
        System.out.println("hello world".indexOf("world"));

        var text = "hello to a brave new world";
        System.out.println(Arrays.toString(text.split(" ")));

    }
}
