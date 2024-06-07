package LabSession5.App2;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Fir1 extends Thread{

    public Lock lock;
    public CountDownLatch cd;

    public int ac_max,ac_min;
    public int delay;

    public Fir1(Lock lock, CountDownLatch cd, int ac_max, int ac_min, int delay) {
        this.lock = lock;
        this.cd = cd;
        this.ac_max = ac_max;
        this.ac_min = ac_min;
        this.delay = delay;
    }

    public void run(){

        System.out.println(this.getName() + " STATE 1");

        this.lock.lock();

        System.out.println(this.getName() + " STATE 2");

        int k = (int) Math.round(Math.random() * (ac_max - ac_min) + ac_min);
        for (int i = 0; i < 100000 * k; i++) {
            i++;
            i--;
        }

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.lock.unlock();

        System.out.println(this.getName() + " STATE 3");

        cd.countDown();

        try {
            cd.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}