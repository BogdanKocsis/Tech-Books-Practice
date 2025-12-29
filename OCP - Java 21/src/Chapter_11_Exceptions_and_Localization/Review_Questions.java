package Chapter_11_Exceptions_and_Localization;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Review_Questions {
    public static void whatHappensNext() throws IOException {
        System.out.println("it's ok");
        // throw new IllegalArgumentException();
        // throw new IOException();
        //throw new RuntimeException();
    }

    public static void print(double t) {
        System.out.println(NumberFormat.getCompactNumberInstance().format(t));

        System.out.println(
                NumberFormat.getCompactNumberInstance(
                        Locale.getDefault(), NumberFormat.Style.SHORT).format(t));

        System.out.println(NumberFormat.getCurrencyInstance().format(t));
    }

    public static class StuckTurkeyCage implements AutoCloseable {
        public void close() throws IOException {
            throw new FileNotFoundException("Cage not closed");
        }

    }

    static class Door implements AutoCloseable {
        public void close() {
            System.out.print("D");
        }
    }

    static class Window implements Closeable {
        public void close() {
            System.out.print("W");
            throw new RuntimeException();
        }
    }

    public static class DriveBus {
        public void go() {
            System.out.print("A");
            try {
                stop();
            } catch (ArithmeticException e) {
                System.out.print("B");
            } finally {
                System.out.print("C");
            }
            System.out.print("D");
        }

        public void stop() {
            System.out.print("E");
            Object x = null;
            x.toString();
            System.out.print("F");
        }
    }

    public record Wallet(double money) {
        private String openWallet() {
            Locale.setDefault(Locale.Category.DISPLAY,
                    new Locale.Builder().setRegion("us").build());
            Locale.setDefault(Locale.Category.FORMAT,
                    new Locale.Builder().setLanguage("en").build());
            return NumberFormat.getCurrencyInstance(Locale.GERMANY)
                    .format(money);
        }

        public void printBalance() {
            System.out.println(openWallet());
        }
    }

    public static void main(String[] args) {

        // Q1
        try {
            whatHappensNext();
        } catch (IOException e) {
            System.out.println("Caught IOException");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
        }

        // Q2
        print(100_102.2);

        // Q9
        String pattern = "#,###,000.0#";
        var message = DoubleStream.of(5.21, 8.49, 1234)
                .mapToObj(v -> new DecimalFormat(pattern).format(v))
                .collect(Collectors.joining("> <"));
        System.out.println("<" + message + ">");

        // Q12
        try (StuckTurkeyCage t = new StuckTurkeyCage()) {
            System.out.println("put turkeys in");
        } catch (Exception e) {
        }

        // Q14
//        var huey = (String)null;
//        Integer dewey = null;
//        Object louie = null;
//        if(louie == huey.substring(dewey.intValue())) { // NullPointerException
//            System.out.println("Quack!");
//        }

        // Q18
        var d = new Door();
        try (d; var w = new Window()) {
            System.out.print("T");
        } catch (Exception e) {
            System.out.print("E");
        } finally {
            System.out.print("F");
        }
        System.out.println();

        // Q20
        //new DriveBus().go();

        // Q22
        try {
            LocalDateTime book = LocalDateTime.of(2025, 4, 5, 12, 30, 20);
            System.out.print(book.format(DateTimeFormatter.ofPattern("m")));
            System.out.print(book.format(DateTimeFormatter.ofPattern("z")));
            System.out.print(DateTimeFormatter.ofPattern("y").format(book));
        } catch (Throwable e) {
        }
        System.out.println();

        // Q25
        new Wallet(2.4).printBalance();
    }

}
