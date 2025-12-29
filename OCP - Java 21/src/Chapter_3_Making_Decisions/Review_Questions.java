package Chapter_3_Making_Decisions;

import java.util.ArrayList;
import java.util.List;

public class Review_Questions {
   /*
   Q5

    void printReptile(int category) {
        var type = switch (category) {
            case 1, 2 -> "Snake";
            case 3, 4 -> "Lizard";
            case 5, 6 -> "Turtle";
            case 7, 8 -> "Alligator";
        };
        System.out.print(type);
    }

    */
    /*
    Q10

    enum DayOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

        private DayOfWeek getWeekDay(int day, final int thursday) {
            int otherDay = day;
            int Sunday = 0;
            switch (otherDay) {
                default:
                case 1: continue; // DOES NOT COMPILE
                case thursday:
                    return DayOfWeek.THURSDAY;
                case 2, 10:
                    break;
                case Sunday: return DayOfWeek.SUNDAY; // DOES NOT COMPILE
                case DayOfWeek.MONDAY:
                    return DayOfWeek.MONDAY;
            }
            return DayOfWeek.FRIDAY;
        }
    }

     */
    /*
    Q13

    int getHatSize(Number measurement) {
        return switch (measurement) {
            case Double d -> 1 + d.intValue();
            case null     -> 11;
            case !(Number n) -> 3 + n.intValue();
                case Float f when f < 10 -> 4 + f.intValue();
        };
    }

     */

    static class Zoo {
        enum Animal {BIRD, FISH, MAMMAL}

        void printLocation(Animal a) {
            long type = switch (a) {
                case BIRD -> 1;
                case FISH -> 2;
                case MAMMAL -> 3;
                default -> 4;
            };
            System.out.println(type);
        }
    }

    private static void countAttendees() {
        int participants = 4, animals = 2, performers = -1;

        while ((participants = participants + 1) < 10) {
        }
        do {
        } while (animals++ <= 1);
        for (; performers < 2; performers += 2) {
        }

        System.out.println(participants);
        System.out.println(animals);
        System.out.println(performers);
    }


    public static void main(String[] args) {

        /*
        Q1

        Object skips = 10;
        switch (skips) {
        case a when a < 10  ->System.out.print(2); // DOES NOT COMPILE
            case b when b >= 10 ->System.out.print(4); // DOES NOT COMPILE
            case null -> System.out.print(6);
            default -> System.out.print(8);
        }

         */

        // Q3

        int temperature = 4;
        long humidity = -temperature + temperature * 3;
        if (temperature >= 4) if (humidity < 6) System.out.println("Too Low");
        else System.out.println("Just Right");
        else System.out.println("Too High");

        /*
        Q6

        List<Integer> myFavoriteNumbers = new ArrayList<>();
        myFavoriteNumbers.add(10);
        myFavoriteNumbers.add(14);
        for (var a : myFavoriteNumbers) {
            System.out.print(a + ", ");
            break;
        }

        for (int b : myFavoriteNumbers) {
            continue;
            System.out.print(b + ", ");
        }

        for (Object c : myFavoriteNumbers)
            System.out.print(c + ", ");

    */
        // Q11

        var zoo = new Zoo();
        zoo.printLocation(Zoo.Animal.MAMMAL);

        // Q12

        int sing = 8, squawk = 2, notes = 0;
        while (sing > squawk) {
            sing--;
            squawk += 2;
            notes += sing + squawk;
        }
        System.out.println(notes);

        // Q15

        for (var penguin : new int[2])
            System.out.println(penguin);

        var ostrich = new Character[3];
        for (var emu : ostrich)
            System.out.println(emu);

        List<Integer> parrots = new ArrayList<Integer>();
        for (var macaw : parrots)
            System.out.println(macaw);

        // Q18

        countAttendees();

        // Q22

        var tailFeathers = 3;
        final var one = 1;
        switch (tailFeathers) {
            case one:
                System.out.print(3 + " ");
            default:
            case 3:
                System.out.print(5 + " ");
        }
        while (tailFeathers > 1) {
            System.out.print(--tailFeathers + " ");
        }
        System.out.println();

        // Q24

        String zooStatus = "Closed";
        int visitors = switch (zooStatus) {
            case String s when s.equals("Open") -> 10;
            case Object s when s != null && !s.equals("") -> 20;
            case null -> {
                yield 30;
            }
            default -> 40;
        };
        System.out.println(visitors);

        // Q25

        String instrument = "violin";
        final String CELLO = "cello";
        String viola = "viola";
        int p = -1;
        switch (instrument) {
            case "bass":
                break;
            case CELLO:
                p++;
            default:
                p++;
            case "VIOLIN":
                p++;
            case "viola":
                ++p;
                break;
        }
        System.out.println(p);

        // Q27

        byte amphibian = 2;
        String name = "Salamander";
        String color = switch (amphibian) {
            case 1 -> {
                yield "Red";
            }
            case 2 -> {
                if (name.equals("Frog")) yield "Green";
                yield "Blue";
            }
            case 3 -> {
                yield "Purple";
            }
            default -> throw new RuntimeException();
        };
        System.out.println(color);

        // Q29

        int y = -2;
        do System.out.print(++y + " ");
        while (y <= 5);

    }
}
