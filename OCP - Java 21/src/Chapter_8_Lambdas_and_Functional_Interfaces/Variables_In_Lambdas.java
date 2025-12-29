package Chapter_8_Lambdas_and_Functional_Interfaces;

import java.util.function.Consumer;

public class Variables_In_Lambdas {

    private String color;
    public void caw(String name){
        String volume = "loudly";
        Consumer<String> consumer = s -> System.out.println(name + " says " + volume + " that she is " + color);
        consumer.accept(name);

        // volume = "softly"; // Error: Cannot assign a value to final variable 'volume'
    }
    public static void main(String[] args) {

        // Referencing Variables from the Lambda Body
        Variables_In_Lambdas vil = new Variables_In_Lambdas();
        vil.color = "red";
        vil.caw("Polly");
    }
}
