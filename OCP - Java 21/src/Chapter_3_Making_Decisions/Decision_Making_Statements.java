package Chapter_3_Making_Decisions;

public class Decision_Making_Statements {
    void printIntegersGreaterThan5(Number number) {
        if (number instanceof Integer data && data.compareTo(5) > 0)
            System.out.println(data);
    }

    void compareIntegers(Number number) {
        if (number instanceof Integer) {
            Integer data = (Integer) number;
            System.out.println(data.compareTo(5));
        }
    }

    void printOnlyIntegers(Number number) {
        if (number instanceof Integer data)
            System.out.println(data.intValue());
        else
            return;
    }

    public static void main(String[] args) {
        // If-Else Statement

        int hourOfDay = 10;
        if (hourOfDay < 11) {
            System.out.println("Good Morning");
        } else if (hourOfDay < 15) {
            System.out.println("Good Afternoon");
        } else {
            System.out.println("Good Evening");
        }

        // Pattern Matching for instanceof
        Decision_Making_Statements obj = new Decision_Making_Statements();

        obj.compareIntegers(10); // prints 1
        obj.compareIntegers(3); // prints -1

        // Pattern Variables and Expressions
        obj.printIntegersGreaterThan5(10); // prints 10
        obj.printIntegersGreaterThan5(3); // prints nothing
        obj.printIntegersGreaterThan5(5.5); // prints nothing

        //Pattern Matching with null

        String noObjectHere = null;

        if (noObjectHere instanceof String)
            System.out.println("Not printed");
        if (noObjectHere instanceof String s)
            System.out.println("Still not printed");
        if (noObjectHere instanceof String s && s.length() > -1)
            System.out.println("Nope, not this one either");

        //Supported Types

        Number bearHeight = Integer.valueOf(123);
        if (bearHeight instanceof Integer i) {
            System.out.println("I'm an Integer! My value is " + i);
        }
        if (bearHeight instanceof Number n) {
            System.out.println("I'm a Number! My value is " + n);
        }
//      if (bearHeight instanceof String s) {} // DOES NOT COMPILE
        if (bearHeight instanceof Object o) {
            System.out.println("I'm an Object! My value is " + o);
        }

        // Flow Scope
        obj.printOnlyIntegers(10); // prints 10
        obj.printOnlyIntegers(5.5); // prints nothing
    }
}
