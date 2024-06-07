package LabSession5.App2;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Fir2 extends Thread{
    public Lock lock1, lock2;
    public CountDownLatch cd;

    public int ac_max,ac_min;
    public int delay;

    public Fir2(Lock lock1, Lock lock2, CountDownLatch cd, int ac_max, int ac_min, int delay) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.cd = cd;
        this.ac_max = ac_max;
        this.ac_min = ac_min;
        this.delay = delay;
    }

    public void run(){
        while(true){
            System.out.println(this.getName()+" - MIDDLE" + " STATE 1");

            this.lock1.lock();
            this.lock2.lock();


            System.out.println(this.getName()+" - MIDDLE" + " STATE 2");

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


            this.lock1.unlock();

            this.lock2.unlock();

            System.out.println(this.getName()+" - MIDDLE" + " STATE 3");


            cd.countDown();

            try {
                cd.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}