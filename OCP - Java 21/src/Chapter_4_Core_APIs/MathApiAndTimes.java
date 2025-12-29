package Chapter_4_Core_APIs;

import java.time.*;

public class MathApiAndTimes {
    private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        var upTo = start;
        while (upTo.isBefore(end)) {  // check if still before end
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plusMonths(1); // add a month
        }
    }

    public static void main(String[] args) {

        //any example of Math Apis
        int first = Math.max(3, 7); //7
        int second = Math.min(7, -9); //-9

        long low = Math.round(123.34); //123
        long high = Math.round(123.50); //124
        int fromFloat = Math.round(123.45f); //123

        double squared = Math.pow(5, 2); //25.0
        double num = Math.random(); //random number between 0.0 and 1.0

        System.out.println(first);
        System.out.println(second);
        System.out.println(low);
        System.out.println(high);
        System.out.println(fromFloat);
        System.out.println(squared);
        System.out.println(num);

        //----------------------------------------------------------------------------

        // Localdate, LocalDateTime and ZonedDateTime
        //Exist many ways... any example...

        //(.of), (.plus), (.minus), (duration), (period),(toInstante), (truncatedTo)... and other "need access documentation"

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());

        System.out.println("----------------------------------");

        var start = LocalDate.of(2025, Month.JANUARY, 1);
        var end = LocalDate.of(2025, Month.MARCH, 30);
        performAnimalEnrichment(start, end);

        System.out.println("----------------------------------");

        var zone = ZoneId.of("America/Sao_Paulo");
        var now = Instant.now(); // class represent a specific moment in time in the GMT time zone.
        var dateTime = LocalDateTime.now();
        System.out.println(now);
        System.out.println(dateTime);


    }
}
