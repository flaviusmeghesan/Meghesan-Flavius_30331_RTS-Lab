package LabSession4.Lab4App2;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutionThread extends Thread {

    final ReentrantLock monitor1, monitor2, monitorSh;
    int[] times;

    public ExecutionThread(ReentrantLock monitor1, ReentrantLock monitor2, ReentrantLock monitorSh, int[] times) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.monitorSh = monitorSh;
        this.times = times;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (times[1] - times[0]) + times[0]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        monitorSh.lock();
        monitor1.lock();

        System.out.println(this.getName() + " - STATE 2");
        k = (int) Math.round(Math.random() * (times[3] - times[2]) + times[2]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        monitor2.lock();
        monitorSh.unlock();

        System.out.println(this.getName() + " - STATE 3");
        try {
            Thread.sleep((long) times[4] * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor1.unlock();
        monitor2.unlock();
        System.out.println(this.getName() + " - STATE 4");
    }
}
