package Chapter_4_Core_APIs;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Review_Questions {

    public void roar(String roar1, StringBuilder roar2) {
        roar1.concat("!!!");
        roar2.append("!!!");
    }

    public static void main(String[] args) {

        // Q4

        var s = "Hello";
        var t = new String(s);
        if ("Hello".equals(s)) System.out.println("one");
        if (t == s) System.out.println("two");
        if (t.intern() == s) System.out.println("three");
        if ("Hello" == s) System.out.println("four");
        if ("Hello".intern() == t) System.out.println("five");

        // Q5

        var sb = new StringBuilder();
        sb.append("aaa").insert(1, "bb").insert(4, "ccc");
        System.out.println(sb);

        // Q8

        var string = "12345";
        var builder = new StringBuilder("12345");
        System.out.println(builder.charAt(4));
        System.out.println(builder.replace(2, 4, "6").charAt(3));
        System.out.println(string.replace("123", "1").charAt(2));

        // Q12

        var numbers = "012345678".indent(1); //"\n 012345678"
        numbers = numbers.stripLeading(); //"012345678"
        System.out.println(numbers.substring(1, 3)); //12
        System.out.println(numbers.substring(7, 7)); // ""
        System.out.println(numbers.substring(7)); // "78"

        // Q13

        var roar1 = "roar";
        var roar2 = new StringBuilder("roar");
        new Review_Questions().roar(roar1, roar2);
        System.out.println(roar1 + " " + roar2);

        // Q15

        var arr = new String[]{"PIG", "pig", "123"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr, "Pippa"));

        // Q19

        var date = LocalDate.of(2028, Month.MARCH, 12);
        var time = LocalTime.of(1, 30);
        var zone = ZoneId.of("US/Eastern");
        var dateTime1 = ZonedDateTime.of(date, time, zone);
        var dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);

        long diff = ChronoUnit.HOURS.between(dateTime1, dateTime2);
        int hour = dateTime2.getHour();
        boolean offset = dateTime1.getOffset()
                == dateTime2.getOffset();
        System.out.println("diff = " + diff);
        System.out.println("hour = " + hour);
        System.out.println("offset = " + offset);

        // Q21

        var anotherDate = LocalDate.of(2025, Month.APRIL, 30);
        anotherDate.plusDays(2);
        anotherDate.plusYears(3);
        System.out.println(anotherDate.getYear() + " " + anotherDate.getMonth()
                + " " + anotherDate.getDayOfMonth());

        // Q22

        var result = LocalDate.of(2025, Month.OCTOBER, 31)
                .plusYears(1)
                .plusMonths(-5)
                .plusMonths(1)
                .withYear(2026)
                .atTime(LocalTime.of(13, 4));
        System.out.println(result);

    }
}
