package LabSession5.App1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);

        CyclicBarrier barrier = new CyclicBarrier(3,new Runnable(){
            @Override
            public void run() {
                System.out.println("Barrier Routine");
            }
        });
        while(true) {
            Fir f1 = new Fir(1, s1, s2, barrier, 4, new int[]{2, 4}, new int[]{4, 6}, 1);
            Fir f2 = new Fir(2, s1, s2, barrier, 5, new int[]{3, 5}, new int[]{5, 7}, 1);


            f1.start();
            f2.start();
            barrier.await();
            barrier.reset();
        }
    }
}