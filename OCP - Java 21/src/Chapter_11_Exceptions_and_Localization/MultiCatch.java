package Chapter_11_Exceptions_and_Localization;

import java.io.IOException;
import java.util.IllegalFormatException;

public class MultiCatch {
    public static void dumbMethod() throws Exception {
    }

    public static void main(String[] args) {
        try {
            dumbMethod();
        } catch (NullPointerException | IllegalFormatException | IOException e) {
            System.out.println("Caught one of the exceptions");
        } catch (Exception ex) {
            System.out.println("Caught Exception");
        }
    }
}
