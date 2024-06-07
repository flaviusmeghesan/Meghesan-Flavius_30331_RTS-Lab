package LabSession5.App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch ;

        Lock P9 = new ReentrantLock();
        Lock P10 = new ReentrantLock();
        while (true) {
            countDownLatch = new CountDownLatch(4);
            Fir1 f1 = new Fir1(P9, countDownLatch, 4, 2, 4);
            Fir2 f2 = new Fir2(P9, P10, countDownLatch, 6, 3, 3);
            Fir1 f3 = new Fir1(P10, countDownLatch, 5, 2, 5);
            f1.setName("Fir1");
            f2.setName("Main");
            f3.setName("Fir2");
            f1.start();
            f2.start();
            f3.start();
            countDownLatch.countDown();
            countDownLatch.await();
        }
    }
}