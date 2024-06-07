package LabSession5.App3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        CountDownLatch T11 = new CountDownLatch(3);

        ReentrantLock P6 = new ReentrantLock();
        ReentrantLock P10 = new ReentrantLock();

        new Thread1(P6,P10,7,2,3,T11).start();
        new Thread2(P6,3,5,T11).start();
        new Thread2(P10,4,6,T11).start();


//        try{
//            T11.await();
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }

    }
}