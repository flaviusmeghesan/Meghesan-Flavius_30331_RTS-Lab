package LabSession3.App4;

public class Thread1 extends Thread{
    Thread th2,th3;

    int sleepTh1, activity_minTh1, activity_maxTh1;
    Monitor monitor,monitor2;
    public Thread1(Monitor monitor, Monitor monitor2, int sleepTh1, int activity_minTh1, int activity_maxTh1) {
        this.monitor=monitor;
        this.monitor2=monitor2;
        this.sleepTh1 = sleepTh1;
        this.activity_minTh1 = activity_minTh1;
        this.activity_maxTh1 = activity_maxTh1;

    }

    public void run() {

            System.out.println(this.getName() + " - STATE 1");
            try {
                Thread.sleep(sleepTh1 * 200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activity_maxTh1
                    - activity_minTh1) + activity_minTh1);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            monitor.start();
            monitor2.start();
            System.out.println(this.getName() + " - STATE 3");

    }
}


