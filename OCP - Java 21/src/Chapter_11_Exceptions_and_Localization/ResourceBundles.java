package Chapter_11_Exceptions_and_Localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundles {
    public static void printWelcomeMessage(Locale locale) {
        var rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello")
                + ", " + rb.getString("open"));
    }

    public static void main(String[] args) {

        var us = Locale.of("en", "US");
        var france = Locale.of("fr", "FR");
        printWelcomeMessage(us);     // Hello, The Chapter_12_Modules.feeding.Chapter_12_Modules.feeding.feeding.zoo is open
        printWelcomeMessage(france); // Bonjour, Le Chapter_12_Modules.feeding.Chapter_12_Modules.feeding.feeding.zoo est ouvert
    }
}

