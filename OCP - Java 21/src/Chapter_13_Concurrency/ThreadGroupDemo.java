package Chapter_13_Concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadGroupDemo {
    public static void execute() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var threadGroup = new ThreadGroup("MyThreadGroup");

        var t0 = new Thread(threadGroup, ThreadGroupDemo::execute);
        var t1 = new Thread(threadGroup, ThreadGroupDemo::execute);
        var t2 = new Thread(threadGroup, ThreadGroupDemo::execute);
        var t3 = new Thread(threadGroup, ThreadGroupDemo::execute);

        t0.start();
        t1.start();
        t2.start();
        t3.start();

        TimeUnit.SECONDS.sleep(2);
        threadGroup.interrupt();

    }
}
