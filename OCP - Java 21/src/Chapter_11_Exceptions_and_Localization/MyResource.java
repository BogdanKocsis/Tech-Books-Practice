package Chapter_11_Exceptions_and_Localization;

public class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing My Resource");
    }
}