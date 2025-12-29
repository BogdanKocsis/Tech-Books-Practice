package Chapter_6_Class_Design;

public class Review_Questions {

    static class Speedster {
        int numSpots;
    }

    public static class Cheetah extends Speedster {
        int numSpots;

        public Cheetah(int numSpots) {
            super.numSpots = numSpots;
        }
    }

    static class Arthropod {
        protected void printName(long input) {
            System.out.print("Arthropod");
        }

        void printName(int input) {
            System.out.print("Spooky");
        }
    }

    public static class Spider extends Arthropod {
        protected void printName(int input) {
            System.out.print("Spider");
        }
    }

    abstract static class Bird {
        private final void fly() {
            System.out.println("Bird");
        }

        protected Bird() {
            System.out.print("Wow-");
        }
    }

    public static class Pelican extends Bird {
        public Pelican() {
            System.out.print("Oh-");
        }

        protected void fly() {
            System.out.println("Pelican");
        }
    }

    public static class PolarBear {

        StringBuilder value = new StringBuilder("t");

        {
            value.append("a");
        }

        {
            value.append("c");
        }

        private PolarBear() {
            value.append("b");
        }

        public PolarBear(String s) {
            this();
            value.append(s);
        }

        public PolarBear(CharSequence p) {
            value.append(p);
        }
    }

    static class Arachnid {
        static StringBuilder sb = new StringBuilder();

        {
            sb.append("c");
        }

        static {
            sb.append("u");
        }

        {
            sb.append("r");
        }
    }

    public static class Scorpion extends Arachnid {
        static {
            sb.append("q");
        }


        {
            sb.append("m");
        }
    }

    static class Birds {
        int feathers = 0;

        Birds(int x) {
            this.feathers = x;
        }

        Birds fly() {
            return new Birds(1);
        }
    }

    static class Parrot extends Birds {
        protected Parrot(int y) {
            super(y);
        }

        protected Parrot fly() {
            return new Parrot(2);
        }
    }

    public static class Macaw extends Parrot {


        public Macaw(int z) {
            super(z);
        }


        public Macaw fly() {
            return new Macaw(3);
        }
    }

    static class Person {
        static String name;

        void setName(String q) {
            name = q;
        }
    }

    public static class Child extends Person {
        static String name;

        void setName(String w) {
            name = w;
        }
    }


    static class Canine {


        public Canine(boolean t) {
            logger.append("a");
        }


        public Canine() {
            logger.append("q");
        }

        private StringBuilder logger = new StringBuilder();


        protected void print(String v) {
            logger.append(v);
        }

        protected String view() {
            return logger.toString();
        }

    }


    static class Fox extends Canine {

        public Fox(long x) {
            print("p");
        }


        public Fox(String name) {
            this(2);
            print("z");
        }

    }


    public static class Fennec extends Fox {

        public Fennec(int e) {
            super("tails");
            print("j");
        }


        public Fennec(short f) {
            super("eevee");
            print("m");
        }
    }

    static class Antelope {
        public Antelope(int p) {
            System.out.print("4");
        }

        {
            System.out.print("2");
        }

        static {
            System.out.print("1");
        }
    }

    public static class Gazelle extends Antelope {


        public Gazelle(int p) {
            super(6);
            System.out.print("3");
        }

        static {
            System.out.print("8");
        }

        {
            System.out.print("9");
        }
    }

    public static void main(String[] args) {

        // Q5
        Speedster s = new Cheetah(50);
        System.out.println(s.numSpots);

        // Q6
        Arthropod a = new Spider();
        a.printName((short) 4);
        a.printName(4);
        a.printName(5L);
        System.out.println();

        // Q7
        var chirp = new Pelican();
        chirp.fly();

        // Q11
        Object bear = new PolarBear();
        bear = new PolarBear("f");
        System.out.println(((PolarBear) bear).value);

        // Q16
        System.out.print(Scorpion.sb + " ");
        System.out.print(Scorpion.sb + " ");
        new Arachnid();
        new Scorpion();
        System.out.print(Scorpion.sb);
        System.out.println();

        // Q20
        Birds p = new Macaw(4);
        System.out.println(((Parrot) p.fly()).feathers);

        // Q22
        final Child m = new Child();
        final Person t = m;
        m.name = "Elysia";
        t.name = "Sophia";
        m.setName("Webby");
        t.setName("Olivia");
        System.out.println(m.name + " " + t.name);

        // Q23
        System.out.println(new Fennec(1).view());

        // Q24
        new Gazelle(0);
    }

}
