package Chapter_1_Building_Blocks;

public class Defining_Text_Blocks {

// String block = """ doe """; DOES NOT COMPILE

    /**
     * The text block requite a line break after tje opening """;
     */

    static String block = """
            doe
            deer""";

    static String eyeTest = "\"Java Study Guide\"\n   by Jeanne & Scott";

    public String label(String title, String author) {
        return """
                Book:
                """ + title + " by " + author;
    }

    public void prepare() {
        String labelled = label("""
                Java Study Guide
                For Java 21
                2024 Edition""", "Jeanne & Scott");
        System.out.println(labelled);
    }

//use "\" tells java not to add a new line before deer.

    public static void main(String[] args) {
        System.out.println(block);
        System.out.println("-----");
        System.out.println(eyeTest);
        System.out.println("-----");
        new Defining_Text_Blocks().prepare();
        System.out.println("-----");
        String pyramid = """
                  *
                 * *
                * * * 
                """;
        System.out.print(pyramid);
    }

}