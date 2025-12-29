package Chapter_1_Building_Blocks;


public class Review_Questions {
    /*
     Q5

     public static class Bear {
         private Bear pandaBear;

         private void roar(Bear b) {
             System.out.println("Roar!");
             pandaBear = b;
         }
     }

     public static void main(String[] args) {

         Bear brownBear = new Bear();
         Bear polarBear = new Bear();
         brownBear.roar(polarBear);
         polarBear = null;
         brownBear = null;
         System.gc();
     }

     */

    /*
    Q7

    public static class KitchenSink {
        private int numForks;

        public static void main(String[] args) {
            int numKnives;
            System.out.print("""
                    "# forks = " + numForks +
                     " # knives = " + numKnives +
                    # cups = 0""");
        }
    }

     */

    /*
    Q10 & Q16

    public static void main(String[] args) {

       var magic = 3_1;
       //var magic = 1_329_.0; // DOES NOT COMPILE
       //var magic = 3_13.0_; // DOES NOT COMPILE
       //var magic = 5_291._2 ; // DOES NOT COMPILE
       //var magic = 2_234.0_0; // DOES COMPILE
       //var magic = 9__67; // DOES COMPILE
       //var magic = _1_3_5_0; // DOES NOT COMPILE
       System.out.println(magic);

        var blocky = """
                squirrel \s
                pigeon   \
                termite""";
        System.out.print(blocky);

    }
    */

    /*
    Q17

    public static class WaterBottle {
        private String brand;
        private boolean empty;
        public static float code;

        public static void main(String[] args) {
            WaterBottle wb = new WaterBottle();
            System.out.println("Empty = " + wb.empty);
            System.out.println("Brand = " + wb.brand);
            System.out.println("Code = " + code);
        }
    }

     */

    /*
    Q19

    public static void main(String[] args) {
        var num1 = Integer.parseInt("11");
        var num2 = Integer.valueOf("B", 16);
        System.out.println(Integer.max(num1, num2));

    }
     */

    /*
    Q20

    public static class PoliceBox {
        String color;
        long age;

        public void PoliceBox() {
            color = "blue";
            age = 1200;
        }

        public static void main(String[] time) {
            var p = new PoliceBox();
            var q = new PoliceBox();
            p.color = "green";
            p.age = 1400;
            p = q;
            System.out.println("Q1=" + q.color);
            System.out.println("Q2=" + q.age);
            System.out.println("P1=" + p.color);
            System.out.println("P2=" + p.age);
        }
    }

     */

    /*
    Q21

    public static class Salmon {
        int count;

        {
            System.out.print(count + "-");
        }

        {
            count++;
        }

        public Salmon() {
            count = 4;
            System.out.print(2 + "-");
        }

        public static void main(String[] args) {
            System.out.print(7 + "-");
            var s = new Salmon();
            System.out.print(s.count + "-");
        }
    }

   */

    public static class Price {
        public void admission() {
            //	int Amount = 0b11; // DOES NOT COMPILE
            //	int amount = 9L; // DOES NOT COMPILE
            int amount = 0xE;
            //	int amount = 1_2.0; // DOES NOT COMPILE
            //	double amount = 1_0_.0; // DOES NOT COMPILE
            //	int amount = 0b101; // DOES COMPILE
            //	double amount = 9_2.1_2; // DOES COMPILE
            //	double amount = 1_2_.0_0; // DOES NOT COMPILE

            System.out.print(amount);
        }

        public static void main(String[] args) {
            Price p = new Price();
            p.admission();
        }
    }

    /*
    Q23

    public static class River {
        int Depth = 1;
        float temp = 50.0;

        public void flow() {
            for (int i = 0; i < 1; i++) {
                int depth = 2;
                depth++;
                temp--;
            }
            System.out.println(depth);
            System.out.println(temp);
        }

        public static void main(String… s) {
            new River().flow();
        }
    }
 */

}

