package OETPN;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String[] args) {
        CyclicBarrier barieer = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier rutine");
            }
        });

        Semaphore s1 = new Semaphore(3);
        Semaphore s2 = new Semaphore(3);
        ExecutionThread ex1 = new ExecutionThread(barieer, s1, s2, 3,2,5,8,6,10,3,8,5);
        ExecutionThread ex2 = new ExecutionThread(barieer, s1, s2, 3,2,5,8,6,10,3,8,5);

        while(true) {
            ex1.start();
            ex2.start();
        }
    }
}
