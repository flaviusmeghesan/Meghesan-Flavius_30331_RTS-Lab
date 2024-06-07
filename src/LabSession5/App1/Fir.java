package LabSession5.App1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir extends Thread{
    Semaphore semaphore1, semaphore2;
    CyclicBarrier barrier;
    int permit;
    int name;
    int[] ac_max,ac_min;
    int delay;

    public Fir(int name, Semaphore semaphore1, Semaphore semaphore2, CyclicBarrier barrier, int delay, int[] ac_min, int[] ac_max, int permit) {
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
        this.name = name;
        this.delay = delay;
        this.permit = permit;
        this.ac_min = ac_min;
        this.ac_max = ac_max;
        this.barrier = barrier;
    }

    public void run() {

        System.out.println("Thread " + name + " State 1");
        int k = (int) Math.round(Math.random() * (ac_max[0] - ac_min[0]) + ac_min[0]);
        for (int i = 0; i < 100000 * k; i++) {
            i++;
            i--;
        }


        try {
            semaphore1.acquire(permit);
            System.out.println("Thread " + name + " State 2");
            int k2 = (int) Math.round(Math.random() * (ac_max[1] - ac_min[1]) + ac_min[1]);
            for (int i = 0; i < 100000 * k2; i++) {
                i++;
                i--;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (semaphore2.tryAcquire(permit)) {
            try {
                System.out.println("Thread " + name + " State 3");

                Thread.sleep(this.delay * 500);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore2.release(this.permit);
            }
        }
        semaphore1.release(this.permit);

        System.out.println("Thread " + name + " State 4");


        try {
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }



    }


}