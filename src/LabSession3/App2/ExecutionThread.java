package LabSession3.App2;

public class ExecutionThread extends Thread {
    Integer monitor;
    Integer monitor2;
    int sleep_min, sleep_max, activity_min1, activity_max1,activity_min2, activity_max2;
    public ExecutionThread(Integer monitor,Integer monitor2, int sleep_min, int
            sleep_max, int activity_min, int activity_max, int activity_min2, int activity_max2) {
        this.monitor = monitor;
        this.monitor2=monitor2;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min1 = activity_min;
        this.activity_max1 = activity_max;
        this.activity_min2 = activity_min2;
        this.activity_max2 = activity_max2;

    }
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max1
                - activity_min1) + activity_min1);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        synchronized (monitor ) {

            System.out.println(this.getName() + " - STATE 2");
            k = (int) Math.round(Math.random() * (activity_max2 - activity_min2) + activity_min2);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }

                synchronized (monitor2 ) {
                    System.out.println(this.getName() + " - STATE 3");
                    try {
                        Thread.sleep(sleep_min*500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


        System.out.println(this.getName() + " - STATE 4");
    }
}
