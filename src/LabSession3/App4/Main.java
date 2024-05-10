package LabSession3.App4;

public class Main {
    public static void main(String[] args) {
        Monitor monitor=new Monitor();
        Monitor monitor2=new Monitor();

        Thread1 th1=new Thread1(monitor,monitor2, 7, 2, 3);
        Thread3 th3=new Thread3(monitor2, 7, 4, 6,th1);
        Thread2 th2=new Thread2(monitor, 7, 3, 5,th1);

        th1.start();
        th2.start();
        th3.start();


    }
}
