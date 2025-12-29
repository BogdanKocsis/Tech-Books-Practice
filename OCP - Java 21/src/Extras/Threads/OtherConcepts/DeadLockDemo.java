package Extras.Threads.OtherConcepts;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Deadlock demonstration using ReentrantLock.
 * Two worker methods attempt to acquire two locks in different orders, leading to a potential deadlock
 * situation where each thread holds one lock and waits for the other.
 * What can we do? - Use tryLock with timeouts or use a single lock for both resources.
 */
public class DeadLockDemo {
    private final Lock lockA = new ReentrantLock(true);
    private final Lock lockB = new ReentrantLock(true);

    public void workerOne() {
        lockA.lock();
        System.out.println("Worker One acquired Lock A");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lockB.lock();
        System.out.println("Worker One acquired Lock B");
        lockA.unlock();
        lockB.unlock();
    }

    public void workerTwo() {
        lockB.lock();
        System.out.println("Worker One acquired Lock B");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lockA.lock();
        System.out.println("Worker One acquired Lock A");
        lockA.unlock();
        lockB.unlock();
    }

    public static void main(String[] args) {
        DeadLockDemo demo = new DeadLockDemo();

        Thread t1 = new Thread(demo::workerOne);
        Thread t2 = new Thread(demo::workerTwo);

        t1.start();
        t2.start();

        new Thread(() -> {
            ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
            while (true) {
                long[] threadIds = mxBean.findDeadlockedThreads();
                if (threadIds != null) {
                    System.out.println("Deadlock detected!");
                    ThreadInfo[] threadInfos = mxBean.getThreadInfo(threadIds);
                    for (long id : threadIds) {
                        System.out.println("Thread ID: " + id + " is involved in the deadlock.");
                    }
                    break;
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
