package Chapter_11_Exceptions_and_Localization;

import java.text.NumberFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class NumberFormatDemo {
    public static void main(String[] args) {
        double randomDoubleValue = 1236.45;

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        System.out.println("US Number: " + numberFormat.format(randomDoubleValue));

        numberFormat = NumberFormat.getNumberInstance(new Locale("ro", "RO"));
        System.out.println("Romanian Number: " + numberFormat.format(randomDoubleValue));

        numberFormat = NumberFormat.getInstance(new Locale("gb", "UK"));
        System.out.println("UK Number: " + numberFormat.format(randomDoubleValue));
        numberFormat = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println("German Number: " + numberFormat.format(randomDoubleValue));

        System.out.println("Money in USA:\t\t" + NumberFormat.getCurrencyInstance(Locale.US).format(randomDoubleValue));
        System.out.println("Money in Germany:\t" + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(randomDoubleValue));
        System.out.println("Money in Romania:\t" + NumberFormat.getCurrencyInstance(new Locale("ro", "RO")).
                format(randomDoubleValue));
        System.out.println("Money in India:\t\t" + NumberFormat.getCurrencyInstance(new Locale("hi", "IN")).
                format(randomDoubleValue));
        System.out.println("Money in UK:\t\t" + NumberFormat.getCurrencyInstance(Locale.UK).format(randomDoubleValue));

        ZonedDateTime zoned = ZonedDateTime.now();

        DateTimeFormatter pattern = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
        System.out.println("Date in USA:\t\t" + zoned.format(pattern));

        pattern = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.GERMANY);
        System.out.println("Date in Germany:\t" + zoned.format(pattern));

        pattern = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("ro", "RO"));
        System.out.println("Date in Romania:\t\t" + zoned.format(pattern));

    }
}
