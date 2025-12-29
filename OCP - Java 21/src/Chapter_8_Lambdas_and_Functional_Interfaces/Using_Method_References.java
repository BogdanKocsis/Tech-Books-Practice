package Chapter_8_Lambdas_and_Functional_Interfaces;

public class Using_Method_References {
    // Using method reference
    public interface LearnToSpeak {
        void speak(String sound);
    }

    public class DuckHelper {
        public static void teacher(String name, LearnToSpeak learner) {
            // Exercise patience (omitted)
            learner.speak(name);
        }
    }

    public class Duckling {
        public static void makeSound(String sound) {
            LearnToSpeak learner = System.out::println;
            DuckHelper.teacher(sound, learner);
        }
    }

    // Calling static method
    interface Converter {
        long round(double num);
    }

    // Calling Instance methods on a particular object
    interface StringStart {
        boolean beginningCheck(String prefix);
    }

    interface StringChecker {
        boolean check();
    }

    // Calling Instance methods on a Parameter
    interface StringParameterChecker {
        boolean check(String text);
    }

    interface StringTwoParameterChecker {
        boolean check(String text, String prefix);
    }

    // Calling Constructor
    interface EmptyStringCreator {
        String create();
    }

    public static void main(String[] args) {
        Duckling.makeSound("Quack Quack");

        Converter methodRef = Math::round;
        System.out.println(methodRef.round(100.1));

        var str = "Zoo";
        StringStart methodReference = str::startsWith;
        System.out.println(methodReference.beginningCheck("A"));

        var string = "";
        StringChecker anotherMethodRef = string::isEmpty;
        System.out.print(anotherMethodRef.check());

        StringParameterChecker anotherMethodReference = String::isEmpty;
        System.out.println(anotherMethodReference.check("Zoo"));

        StringTwoParameterChecker method = String::startsWith;
        System.out.println(method.check("Zoo", "A"));

        EmptyStringCreator mRef = String::new;
        var myString = mRef.create();
        System.out.println(myString.equals("Snake"));
    }
}
