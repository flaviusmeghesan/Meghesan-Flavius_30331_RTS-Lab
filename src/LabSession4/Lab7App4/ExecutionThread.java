package LabSession4.Lab7App4;

import java.util.concurrent.Semaphore;

public class ExecutionThread extends Thread {
    Semaphore s;
    int sleep, activity_min, activity_max,permit;
    public ExecutionThread(Semaphore s, int sleep, int activity_min, int activity_max,int permit) {
        this.s = s;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.permit=permit;

    }
    public void run() {
        while(true) {
            System.out.println(this.getName() + " - STATE 1");
            try {
                this.s.acquire(this.permit);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max
                        - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
            this.s.release(this.permit);
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep(sleep * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 4");
        }
    }
}
