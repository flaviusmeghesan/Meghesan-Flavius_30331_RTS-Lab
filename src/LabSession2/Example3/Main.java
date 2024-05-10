package LabSession2.Example3;

public class Main {
    public static int sum=0;
    public static void main(String[] args){
        JoinTestThread w1 = new JoinTestThread("Thread 1",null,50000);
        JoinTestThread w2 = new JoinTestThread("Thread 2",w1,20000);
        w1.start();
        w2.start();
    }
}
