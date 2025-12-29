package Chapter_7_Beyond_Classes;

public class Enums {
    interface Visitors {
        void printVisitors();
    }

    enum SeasonWithVisitors implements Visitors {
        WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");;

        private final String visitors;
        public static final String DESCRIPTION = "Weather enum";

        private SeasonWithVisitors(String visitors) {
            System.out.print("constructing,");
            this.visitors = visitors;
        }

        @Override
        public void printVisitors() {
            System.out.println("Visitors: " + visitors);
        }
    }

    // Enum with method
    public enum SeasonWithTimes {
        WINTER {
            public String getHours() {
                return "10am to 3pm";
            }
        },
        SUMMER {
            public String getHours() {
                return "9am to 7pm";
            }
        },
        SPRING, FALL;

        public String getHours() {
            return "9am to 5pm";
        }
    }

    public static void main(String[] args) {

        SeasonWithVisitors season = SeasonWithVisitors.SUMMER;
        System.out.println("\nSeason: " + season);
        season.printVisitors();
        System.out.println("Description: " + SeasonWithVisitors.DESCRIPTION);

        SeasonWithTimes season2 = SeasonWithTimes.WINTER;
        System.out.println("\nSeason: " + season2);
        System.out.println("Hours: " + season2.getHours());
    }
}
