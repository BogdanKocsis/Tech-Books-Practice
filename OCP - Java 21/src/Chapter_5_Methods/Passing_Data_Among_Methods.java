package Chapter_5_Methods;

public class Passing_Data_Among_Methods {

    /**
     * Java is a "##### pass-by-value ######" language. This means that a copy of variable is made and the method receives tha copy.    *
     * Assignments made in the method do not affect the caller.     *
     */

    public static void main(String[] args) {
        //primitive

        int number = 5;
        newNumber(number);
        System.out.println("number = " + number);
        //the variable on line 12 never changes because no assignments are made to it

        //objects
        String name = "Bogdan";
        talk(name);
        System.out.println(name);
        //the variable on line 18 never changes because no assignments are made to it



        StringBuilder s = new StringBuilder("Hello ");
        speak(s);
        System.out.println(s);
        //the variable changes because the object it references is modified, not reassigned
    }

    public static void speak(StringBuilder s) {
        s.append("Bogdan");
    }

    public static void talk(String name){
        name = "Bogdan";
    }

    public static void newNumber(int number){
        number = 10;
    }
}
