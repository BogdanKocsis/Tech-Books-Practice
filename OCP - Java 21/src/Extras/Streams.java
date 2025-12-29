package Extras;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5, 6, 7, 6, 7, 8, 9, 10);

        // Calculate the average
        var average = numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        System.out.println("Average: " + average);

        // Calculate the sum of all even numbers
        var sumOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of even numbers: " + sumOfEvens);

        // Find the maximum value in the list
        Integer max = numbers.stream()
                .max(Integer::compare)
                .orElse(null);
        System.out.println("Maximum value: " + max);

        // Calculate the sum of squares of all odd numbers in a list.
        int sumOfSquares = numbers.stream().filter(n -> n % 2 != 0)
                .mapToInt(n -> n * n)
                .sum();
        System.out.println("Sum of squares of odd numbers: " + sumOfSquares);

        List<String> colors = List.of("RED", "grEEn", "white", "Orange", "pink");
        System.out.println("List of strings: " + colors);

        // Remove duplicates
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println("Distinct numbers: " + distinctNumbers);

        // Find 2nd smallest number
        Integer secondSmallest = numbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second smallest number: " + secondSmallest);

        // Find 2nd largest number
        Integer secondLargest = numbers.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second largest number: " + secondLargest);

        // Convert strings to uppercase
        List<String> upperCaseColors = colors.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Uppercase colors: " + upperCaseColors);

        // Counting strings starting with specified letter
        char startLetter = 'O';
        long count = colors.stream()
                .filter(s -> s.startsWith(String.valueOf(startLetter)))
                .count();
        System.out.println("Number of strings starting with '" + startLetter + "': " + count);

    }
}
