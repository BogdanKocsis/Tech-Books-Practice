package Extras.Threads.Homework.Level_1;

public class Level_1 {
    private static int counter = 0;

    static class ThreadNumber implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadLetter implements Runnable {
        @Override
        public void run() {
            for (char ch = 'A'; ch <= 'J'; ch++) {
                System.out.print(ch + " ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadRandomNumbers implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                int randomNum = (int) (Math.random() * 100);
                System.out.print(randomNum + " ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static synchronized void incrementCounter() {
        counter++;
    }

    public static void main(String[] args) {
        Thread numbers = new Thread(new ThreadNumber());

        Thread letters = new Thread(new ThreadLetter());

        numbers.start();
        letters.start();

        try {
            numbers.join();
            letters.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nBoth threads have finished execution.");

        Thread randomNumbers_1 = new Thread(new ThreadRandomNumbers(), "RandomNumbers-1");
        Thread randomNumbers_2 = new Thread(new ThreadRandomNumbers(), "RandomNumbers-2");
        Thread randomNumbers_3 = new Thread(new ThreadRandomNumbers(), "RandomNumbers-3");

        randomNumbers_1.start();
        randomNumbers_2.start();
        randomNumbers_3.start();
        try {
            randomNumbers_1.join();
            randomNumbers_2.join();
            randomNumbers_3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nAll random number threads have finished execution.");

        Thread incrementerThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                //counter++;
                incrementCounter();
            }
        });
        Thread incrementerThread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                //counter++;
                incrementCounter();
            }
        });
        incrementerThread.start();
        incrementerThread2.start();
        try {
            incrementerThread.join();
            incrementerThread2.join();
            System.out.println("Final counter value: " + counter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
