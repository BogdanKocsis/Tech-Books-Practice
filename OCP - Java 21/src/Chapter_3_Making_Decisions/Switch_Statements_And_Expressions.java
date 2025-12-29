package Chapter_3_Making_Decisions;

public class Switch_Statements_And_Expressions {

    enum Season {SPRING, SUMMER, FALL, WINTER}

    String getAnimalBetter(int type) {
        String animal;
        switch (type) {
            case 0:
                animal = "Lion";
                break;
            case 1:
                animal = "Elephant";
                break;
            case 2, 3:
                animal = "Alligator";
                break;
            case 4:
                animal = "Crane";
                break;
            default:
                animal = "Unknown";
        }
        return animal;
    }

    String getAnimalBest(int type) {
        return switch (type) {
            case 0 -> "Lion";
            case 1 -> "Elephant";
            case 2, 3 -> "Alligator";
            case 4 -> "Crane";
            default -> "Unknown";
        };
    }

    boolean shouldGetACoat(Season s) {
        return switch (s) {
            case SPRING -> false;
            case Season.SUMMER -> false;
            case FALL -> true;
            case Season.WINTER -> true;
        };
    }

    void printSeasonForMonth(int month) {
        String value = switch (month) {
            case 1, 2, 3 -> "Winter-";
            case 4, 5, 6 -> "Spring-";
            default -> "Unknown-";
            case 7, 8, 9 -> "Summer-";
            case 10, 11, 12 -> "Fall-";
        };
        System.out.print(value);
    }

    static void printWeather(int rain) {
        switch (rain) {
            case 0 -> System.out.println("\nDry");
            case 1 -> System.out.println("\nWet");
            case 2 -> System.out.println("\nStorm");
        }
    }

    String getWeatherCoveredAll(Season value) {
        return switch (value) {
            case WINTER -> "Cold";
            case SPRING -> "Rainy";
            case SUMMER -> "Hot";
            case FALL   -> "Warm";
            default     -> throw new RuntimeException("Unsupported Season");
        };
    }

    String getTrainer(Number height) {
        return switch (height) {
            case Integer i when i > 10 -> "Joseph";
            case Integer i -> "Daniel";
            case Double num when num <= 15.5 -> "Peter";
            case Double num -> "Kelly";
            case Number num -> "Ralph";
        };
    }

    public static void main(String[] args) {
        var obj = new Switch_Statements_And_Expressions();

        System.out.println(obj.getAnimalBetter(3));
        System.out.println(obj.getAnimalBest(3));

        System.out.println(obj.shouldGetACoat(Season.SUMMER));

        for (int month = 1; month <= 12; month++) {
            obj.printSeasonForMonth(month);
        }

        printWeather(2);

        System.out.println(obj.getWeatherCoveredAll(Season.FALL));

        // Switch with yield
        int fish = 5;
        int length = 12;
        var name = switch (fish) {
            case 1 -> "Goldfish";
            case 2 -> { yield "Trout"; }
            case 3 -> {
                if (length> 10) yield "Blobfish";
                else yield "Green";
            }
            case 4 -> {
                throw new RuntimeException("Unsupported value");
            }
            default -> "Swordfish";
        };
        System.out.println(name);

        System.out.println(obj.getTrainer(10));
        System.out.println(obj.getTrainer(5.5));
        System.out.println(obj.getTrainer(20L));
    }
}
