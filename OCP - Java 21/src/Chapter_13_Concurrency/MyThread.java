package Chapter_13_Concurrency;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread is starting.");
        try {
            Thread.sleep(10);
            System.out.println("Sleeping for 10 milliseconds.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread has finished.");
    }
}
