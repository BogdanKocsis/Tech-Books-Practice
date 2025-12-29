package Chapter_11_Exceptions_and_Localization;

/**
 * ==========================================================================================================================================================
 * Types of Exceptions and Errors
 * ==========================================================================================================================================================
 * | Type               | How to Recognize                                           | OK for program to catch? | Is program required to handle or declare? |
 * |--------------------|------------------------------------------------------------|---------------------------|-------------------------------------------|
 * | Unchecked Exception| Subclass of RuntimeException                               | Yes                       | No                                        |
 * | Checked Exception  | Subclass of Exception but not subclass of RuntimeException | Yes                       | Yes                                       |
 * | Error              | Subclass of Error                                          | No                        | No                                        |
 * ==========================================================================================================================================================
 */

public class Exceptions {

    static class CanNotHopException extends Exception {
    }

    static class Hopper {
        public void hop() throws CanNotHopException {
        }
    }

    public static class Bunny extends Hopper {
        public void hop() {
        }
    }

    private static void hop() {
        throw new RuntimeException("cannot hop");
    }

    public static void main(String[] args) {

//        String[] animals = new String[0];
//        System.out.println(animals[0]);  // ArrayIndexOutOfBoundsException

//        var text = (String) null;
//        Integer integer = null;
//        Object obj = null;
//        if (obj == text.substring(integer.intValue())) {
//            System.out.println("Equal"); // NullPointerException
//        }

        try {
            hop();
        } catch (Exception e) {
            System.out.println(e + "\n");
            System.out.println(e.getMessage() + "\n");
            e.printStackTrace();
        }

        //
    }
}
