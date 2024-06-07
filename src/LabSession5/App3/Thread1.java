package LabSession5.App3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Thread1 extends Thread{
    Lock lock1, lock2 ;
    CountDownLatch count;
    int sleep_max, activity_min, activity_max;

    public Thread1(Lock lock1,Lock lock2,int sleep_max, int activity_min, int activity_max,CountDownLatch count) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.count = count;
    }

    public void run(){
        System.out.println(getName() + " State 1");
        try {
            Thread.sleep((sleep_max) * 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getName() + " State 2");

        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);

        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        synchronized (lock1){
            lock1.notify();
            System.out.println(getName() + " Notify lock1");

        }
        synchronized (lock2){
            lock2.notify();
            System.out.println(getName() + " Notify lock2");

        }
        System.out.println(getName() + " State 3");

        count.countDown();
        try {
            count.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}