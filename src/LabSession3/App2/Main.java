package LabSession3.App2;

public class Main {
    public static void main(String[] args) {
        Integer monitor = new Integer(1);
        Integer monitor2 = new Integer(1);
        new ExecutionThread(monitor,monitor2, 4, 4, 2, 4,4,6).start();
        new ExecutionThread(monitor2,monitor, 5, 5, 3, 5,5,7).start();
    }
}
