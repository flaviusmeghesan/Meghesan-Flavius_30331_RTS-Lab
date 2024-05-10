package LabSession4.App2;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String args[]) {
        Semaphore s = new Semaphore(4);
        Fir f1, f2;
        f1 = new Fir(1, s, 2, (int) Math.round(Math.random() * 3 + 2), 2);
        f2 = new Fir(2, s, 4, (int) Math.round(Math.random() * 3 + 3), 2);
        f1.start();
        f2.start();
    }
}