package LabSession4.Lab7App4;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore s=new Semaphore(2);
        ExecutionThread e1,e2,e3;
        e1=new ExecutionThread(s, 5, 3, 6,1);
        e2=new ExecutionThread(s, 3, 4, 7,1);
        e3=new ExecutionThread(s, 6, 5, 7,1);
        e1.start();
        e2.start();
        e3.start();

    }
}
