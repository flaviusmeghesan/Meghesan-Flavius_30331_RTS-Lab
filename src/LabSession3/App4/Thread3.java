package LabSession3.App4;

public class Thread3 extends  Thread{
    int sleepTh1, activity_minTh1, activity_maxTh1;
    Monitor monitor;
    Thread th1;
    public Thread3(Monitor monitor, int sleepTh1, int activity_minTh1, int activity_maxTh1, Thread1 th1) {
        this.monitor=monitor;
        this.sleepTh1 = sleepTh1;
        this.activity_minTh1 = activity_minTh1;
        this.activity_maxTh1 = activity_maxTh1;
        this.th1=th1;
    }
    public void run() {

            System.out.println(this.getName() + " - STATE 1");
            monitor.read();
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activity_maxTh1
                    - activity_minTh1) + activity_minTh1);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(this.getName() + " - STATE 3");
            if (this.th1!=null) {
                try {
                    th1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

    }

}
