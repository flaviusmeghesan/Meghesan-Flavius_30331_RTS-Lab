package LabSession5.App3;


import java.util.concurrent.CountDownLatch;

public class Thread2 extends Thread{
    public Object lock =  new Object();
    public CountDownLatch count;
    public int activity_min, activity_max;

    public Thread2(Object lock, int activity_min, int activity_max, CountDownLatch count) {
        this.lock = lock;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.count = count;
    }

    public void run(){
        System.out.println(getName() + " State 1");
        try {
            Thread.sleep(500*5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println(getName() + " State 2");

        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);

        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
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