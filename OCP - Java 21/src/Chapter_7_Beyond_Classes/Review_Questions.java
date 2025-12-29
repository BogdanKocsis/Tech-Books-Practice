package Chapter_7_Beyond_Classes;

import java.util.List;

public class Review_Questions {
    record Walrus(List<String> diet) {
    }

    record Exhibit(Walrus animal, String location) {
    }

    abstract static class Snake {
    }

    static class Cobra extends Snake {
    }

    static class GardenSnake extends Cobra {
    }

    private Snake snake;

    public void setSnake(Snake mySnake) {
        this.snake = mySnake;
    }

    public static class Movie {
        private int butter = 5;

        private Movie() {
        }

        protected class Popcorn {
            private Popcorn() {
            }

            public static int butter = 10;

            public void startMovie() {
                System.out.println(butter);
            }
        }
    }

    interface Swim {
        default void perform() {
            System.out.print("Swim!");
        }
    }

    interface Dance {
        default void perform() {
            System.out.print("Dance!");
        }
    }

    public class Penguin implements Swim, Dance {
        public void perform() {
            System.out.print("Smile!");
        }

        private void doShow() {
            Swim.super.perform();
        }
    }

    public class Zebra {
        private int x = 24;

        public int hunt() {
            String message = "x is ";
            abstract class Stripes {
                private int x = 0;

                public void print() {
                    System.out.print(message + Zebra.this.x);
                }
            }
            var s = new Stripes() {
            };
            s.print();
            return x;
        }
    }

    public static void main(String[] args) {

        // Q8
        var e = new Exhibit(new Walrus(List.of("Wally")), "Artic");
        System.out.println(e instanceof Exhibit(Walrus(List m), Object n));
        System.out.println(e instanceof Exhibit(var p, var q));
        System.out.println(e instanceof Exhibit(var x, CharSequence y));

        // Q9
        new Review_Questions().setSnake(new Cobra());
        new Review_Questions().setSnake(new GardenSnake());
        new Review_Questions().setSnake(null);

        // Q11
        var movie = new Movie();
        Movie.Popcorn in = new Movie().new Popcorn();
        in.startMovie();

        // Q23
        Penguin penguin = new Review_Questions().new Penguin();
        penguin.doShow();
        System.out.println();

        // Q25
        Zebra zebra = new Review_Questions().new Zebra();
        zebra.hunt();
        System.out.println();

    }

}
